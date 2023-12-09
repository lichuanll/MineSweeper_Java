package Minsweeper_code;

import java.awt.*;

public class DrawBottomComponents {

    Mines mines =new Mines();//由于代码块的存在，要注意new的先后顺序，和new的次数
    Numbers numbers=new Numbers();

    {
        mines.SetupMines();
        numbers.SetupNumber();
    }
    void PaintLine(Graphics g)
    {

            g.setColor(Color.blue);

        for(int i = 0; i<= GameComponents.map_w; i++)
        {
            g.drawLine(i* GameComponents.square_length + GameComponents.offset,
                       3* GameComponents.offset,
                       i* GameComponents.square_length + GameComponents.offset,
                       3* GameComponents.offset+ GameComponents.map_h* GameComponents.square_length);
        }
        for(int i = 0; i<= GameComponents.map_h; i++)
        {
            g.drawLine(/*x1:*/GameComponents.offset,
                        3* GameComponents.offset+i* GameComponents.square_length,
                        GameComponents.offset+ GameComponents.map_w* GameComponents.square_length,
                        3* GameComponents.offset+i* GameComponents.square_length
                      );
        }

    }
    void PaintMine(Graphics g)
    {
        for(int i = 0; i< GameComponents.map_w; i++)
        {
            for(int j = 0; j< GameComponents.map_h; j++)//画了11*11个雷
            {
                if(GameComponents.Map[i+1][j+1]==-1)//随机数是1-12所以+1
                {
                    g.drawImage(GameComponents.mine_image,
                            GameComponents.offset+i* GameComponents.square_length+1,
                            GameComponents.offset*3+j* GameComponents.square_length+1,
                            GameComponents.square_length-2,
                            GameComponents.square_length-2,null);
                }
            }
        }
    }
    void PaintNumber(Graphics g)
    {
        for(int i = 0; i< GameComponents.map_w; i++)
        {
            for(int j = 0; j< GameComponents.map_h; j++)
            {
                if(GameComponents.Map[i+1][j+1]>0)//随机数是1-12所以+1
                {
                    g.drawImage(GameComponents.num_image[GameComponents.Map[i+1][j+1]],
                            GameComponents.offset+i* GameComponents.square_length+1,
                            GameComponents.offset*3+j* GameComponents.square_length+1,
                            GameComponents.square_length-2,
                            GameComponents.square_length-2,null);
                }
            }
        }
    }

}
