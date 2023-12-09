package Minsweeper_code;

import javax.swing.*;

public class GamePlay {
    public GamePlay()
    {

    }
    Mines mines=new Mines();
    Numbers numbers=new Numbers();

    int temp_x;
    int temp_y;
    void MouseLogic()
    {
        temp_x=0;//转换坐标
        temp_y=0;
        if(GameComponents.Mouse_x>GameComponents.offset && GameComponents.Mouse_y>3*GameComponents.offset)//使temp_x,temp_y的值大于0
        {
            temp_x=(GameComponents.Mouse_x-GameComponents.offset)/GameComponents.square_length+1;
            temp_y=(GameComponents.Mouse_y-GameComponents.offset*3)/GameComponents.square_length+1;
        }
        if(temp_x>=1 && temp_x<=GameComponents.map_w && temp_y>=1 && temp_y<=GameComponents.map_h)//确保坐标在可交互区域
        {
            if(GameComponents.Mouse_left)//如果点击鼠标左键
            {
                if(GameComponents.Map_Top[temp_x][temp_y]==0)
                {
                    GameComponents.Map_Top[temp_x][temp_y]=-1;
                    if(GameComponents.Map[temp_x][temp_y]!=-1)
                    {
                        GameComponents.score++;
                    }

                }
                OpenSpace(temp_x,temp_y);
                GameComponents.Mouse_left=false;
            }
            if(GameComponents.Mouse_right)//如果点击鼠标右键
            {
                if(GameComponents.Map_Top[temp_x][temp_y]==0)
                {
                    GameComponents.Map_Top[temp_x][temp_y]=1;
                }
                else if(GameComponents.Map_Top[temp_x][temp_y]==1)
                {
                    GameComponents.Map_Top[temp_x][temp_y]=0;
                }
                else if(GameComponents.Map_Top[temp_x][temp_y]==-1)
                {
                    OpenNumber(temp_x,temp_y);
                }
                GameComponents.Mouse_right=false;
            }
        }
        IfDefeat();
        IfVictory();
    }
    void OpenSpace(int x,int y)
    {
        if(GameComponents.Map[x][y]==0)
        {
            for(int i=x-1;i<=x+1;i++)
            {
                for(int j=y-1;j<=y+1;j++)
                {
                    if(i!=x||j!=y)
                    {
                        if(GameComponents.Map_Top[i][j]!=-1&&GameComponents.Map_Top[i][j]!=1)
                        {
                            GameComponents.Map_Top[i][j] = -1;
                            if(i >= 1 && i <= GameComponents.map_w && j >= 1 && j <= GameComponents.map_h)//确保再可交互范围内
                            {
                                GameComponents.score++;
                                OpenSpace(i,j);
                            }
                        }
                    }
                }
            }
        }
    }
    void OpenNumber(int x,int y)//右键数字的事件
    {
        int flag_count=0;
        if(GameComponents.Map[x][y]>0)//判断是否为数字
        {
            for(int i=x-1;i<=x+1;i++)
            {
                for (int j = y - 1; j <= y + 1; j++)
                {
                    if(GameComponents.Map_Top[i][j]==1)//统计旗子的数量
                    {
                        flag_count++;

                    }
                }
            }
            System.out.println(flag_count);
            if(flag_count==GameComponents.Map[x][y])//判断旗子数量与所点击的位置数字是否相同
            {
                for(int i=x-1;i<=x+1;i++)
                {
                    for (int j = y - 1; j <= y + 1; j++)
                    {
                        if(GameComponents.Map_Top[i][j]!=1)//判断有没有插旗
                        {
                           GameComponents.Map_Top[i][j]=-1;//如果没有则翻开
                        }
                        if(i >= 1 && i <= GameComponents.map_w && j >= 1 && j <= GameComponents.map_h)//确保再可交互范围内
                        {
                            OpenSpace(i,j);
                        }
                    }
                }
            }
        }
    }
    boolean IfDefeat()
    {
        for(int i=1;i<=GameComponents.map_w;i++)
        {
            for(int j=1;j<=GameComponents.map_h;j++)
            {
                if(GameComponents.Map[i][j]==-1&&GameComponents.Map_Top[i][j]==-1)
                {
                    GameComponents.state=2;//修改游戏状态
                    ShowAllMines();
                    //JOptionPane.showMessageDialog(null, "你输了");
                    return true;
                }
            }
        }
        return false;
    }
    void ShowAllMines()
    {
        for(int i=1;i<=GameComponents.map_w;i++)
        {
            for (int j = 1; j <= GameComponents.map_h; j++)
            {
                if(GameComponents.Map[i][j]==-1)
                {
                    GameComponents.Map_Top[i][j]=-1;
                }
                if(GameComponents.Map[i][j]!=-1&&GameComponents.Map_Top[i][j]==1)
                {
                    GameComponents.Map_Top[i][j]=2;
                }
            }
        }
    }
    boolean IfVictory()
    {
        int NoOpenCount=0;
        for (int i = 1; i <= GameComponents.map_w; i++)
        {
            for(int j = 1; j <= GameComponents.map_h; j++)
            {
                if(GameComponents.Map_Top[i][j]!=-1)
                {
                    NoOpenCount++;
                }
            }
        }
        if(NoOpenCount==GameComponents.mine_count&&!IfDefeat())
        {
            GameComponents.state=1;//修改游戏状态
            for (int i = 1; i <= GameComponents.map_w; i++)
            {
                for(int j = 1; j <= GameComponents.map_h; j++)
                {
                    if(GameComponents.Map[i][j]==-1)
                    {
                        GameComponents.Map_Top[i][j]=3;
                    }
                }
            }

            return true;
        }
        return false;
    }

    void RePlay()
    {
        for(int i=1;i<=GameComponents.map_w;i++)
        {
            for(int j=1;j<=GameComponents.map_h;j++)
            {
                GameComponents.Map[i][j]=0;
            }
        }
        for(int i=1;i<=GameComponents.map_w;i++)
        {
            for(int j=1;j<=GameComponents.map_h;j++)
            {
                GameComponents.Map_Top[i][j]=0;
            }
        }
        GameComponents.state=0;

        GameComponents.score=0;
        GameComponents.IfFirst=true;
        mines.SetupMines();
        numbers.SetupNumber();

    }
}
