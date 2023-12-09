package Minsweeper_code;

import java.awt.*;

public class DrawTopComponents {

    //GamePlay gamePlay =new GamePlay();
    static void drawWord(Graphics g,String str,int x, int y,Color color){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,30));
        g.drawString(str, x, y);
    }
    void PaintTop(Graphics g)
    {
        drawWord(g,GameComponents.score+"分",10,50,Color.BLUE);
        drawWord(g,"按R键查看历史得分",1050,100,Color.BLUE);
        drawWord(g,"按“A、B、C”键选择简单“简单、中等、困难”",50,100,Color.BLUE);
        //gamePlay.MouseLogic();
        for(int i = 0; i< GameComponents.map_w; i++)
        {
            for(int j = 0; j< GameComponents.map_h; j++)
            {
                if(GameComponents.Map_Top[i+1][j+1]==0)//随机数是1-12所以+1
                {
                    g.drawImage(GameComponents.top_image,
                            GameComponents.offset+i* GameComponents.square_length+1,
                            GameComponents.offset*3+j* GameComponents.square_length+1,
                            GameComponents.square_length-2,
                            GameComponents.square_length-2,null);
                }
                if(GameComponents.Map_Top[i+1][j+1]==1)//随机数是1-12所以+1
                {
                    g.drawImage(GameComponents.flag_image,
                            GameComponents.offset+i* GameComponents.square_length+1,
                            GameComponents.offset*3+j* GameComponents.square_length+1,
                            GameComponents.square_length-2,
                            GameComponents.square_length-2,null);
                }
                if(GameComponents.Map_Top[i+1][j+1]==2)//随机数是1-12所以+1
                {
                    g.drawImage(GameComponents.wrong_flag_image,
                            GameComponents.offset+i* GameComponents.square_length+1,
                            GameComponents.offset*3+j* GameComponents.square_length+1,
                            GameComponents.square_length-2,
                            GameComponents.square_length-2,null);
                }
                if(GameComponents.Map_Top[i+1][j+1]==3)//随机数是1-12所以+1
                {
                    g.drawImage(GameComponents.mine_flag_image,
                            GameComponents.offset+i* GameComponents.square_length+1,
                            GameComponents.offset*3+j* GameComponents.square_length+1,
                            GameComponents.square_length-2,
                            GameComponents.square_length-2,null);
                }
            }
        }
        switch (GameComponents.state)
        {
            case 0:
                g.drawImage(GameComponents.face_image,
                        795,//GameComponents.offset+GameComponents.square_length*(GameComponents.map_w/2),//795,45
                      /*y:*/45,//GameComponents.offset,
                        null
                        );

                break;
            case 1:
                g.drawImage(GameComponents.win_image,
                        795,45,
                        null
                );
                break;
            case 2:
                g.drawImage(GameComponents.over_image,
                        795,45,
                        null
                );
                break;
            default:
                break;
        }
    }
}
