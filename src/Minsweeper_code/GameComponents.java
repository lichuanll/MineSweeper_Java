package Minsweeper_code;

import java.awt.*;

public class GameComponents {
    int a;

    static int score=0;
    static int map_w=30;
    static int map_h=16;
    static int offset=45;
    static int square_length=30;
    static int mine_count=99;
    static int Mouse_x;
    static int Mouse_y;
    static int state=0;//0代表游戏中，1代表胜利，2代表失败
    static boolean Mouse_left=false;
    static boolean Mouse_right=false;
    static boolean IfFirst=true;
    static int [][] Map = new int[50][50];   //-1代表雷，1-8代表数字 0代表周围没有地雷
    static int [][] Map_Top =new int[50][50];   //顶层，-1无覆盖，0覆盖，1插旗，2插错旗,3胜利以后结束后的雷
    static Image mine_image=Toolkit.getDefaultToolkit().getImage("src/images/lei.png");
    static Image top_image=Toolkit.getDefaultToolkit().getImage("src/images/top.gif");
    static Image flag_image=Toolkit.getDefaultToolkit().getImage("src/images/flag.gif");
    static Image wrong_flag_image=Toolkit.getDefaultToolkit().getImage("src/images/noflag.png");
    static Image mine_flag_image=Toolkit.getDefaultToolkit().getImage("src/images/leiflag.png");
    static Image face_image=Toolkit.getDefaultToolkit().getImage("src/images/over.png");
    static Image over_image=Toolkit.getDefaultToolkit().getImage("src/images/over.png");
    static Image win_image=Toolkit.getDefaultToolkit().getImage("src/images/over.png");
    static Image[]num_image=new Image[9];
    static {
        for(int i=1;i<=8;i++)
        {
            num_image[i]=Toolkit.getDefaultToolkit().getImage("src/images/"+i+".png");
        }
        }
}
