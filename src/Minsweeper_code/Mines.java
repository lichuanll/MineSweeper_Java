package Minsweeper_code;

public class Mines{
    public Mines()
    {

    }
       static int [] mines_x=new int[105];
       static int [] mines_y=new int[105];
     int x;
     int y;
     boolean flag=true;

     void SetupMines()
    {

        for(int i = 0; i< GameComponents.mine_count; i++)
        {
            x= (int) (Math.random()* GameComponents.map_w+1);//产生1-12的随机数
            y= (int) (Math.random()* GameComponents.map_h+1);

            for(int j=0;j<i;j++)//判断本次随机生成的x,y坐标之前是否重复
            {
                if(x==mines_x[j]&&y==mines_y[j])//如果重复
                {
                    i--;//本次循环不生效,且加一次循环
                    flag=false;
                    break;
                }
            }
            if(flag)//先判断再放置
            {
                mines_x[i]=x;
                mines_y[i]=y;
            }
            flag=true;

        }
        for(int i = 0; i< GameComponents.mine_count; i++)
        {
            GameComponents.Map[mines_x[i]][mines_y[i]]=-1;
        }

    }

}
