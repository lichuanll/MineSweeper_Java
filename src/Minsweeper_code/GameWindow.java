package Minsweeper_code;
import com.sun.javafx.scene.traversal.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindow extends JFrame{
    int width = 2* GameComponents.offset+ GameComponents.map_w* GameComponents.square_length;
    int height = 4* GameComponents.offset+ GameComponents.map_h* GameComponents.square_length;
    Image FBO=null;
    DrawBottomComponents drawBottomComponents = new DrawBottomComponents();
    DrawTopComponents drawTopComponents = new DrawTopComponents();
    GamePlay gamePlay = new GamePlay();


    void startup()
    {
        this.setVisible(true);
        this.setSize(width,height);


        this.setLocationRelativeTo(null);//设置窗口位置：null代表居中显示
        this.setTitle("扫雷");
        this.setResizable(false);//禁止窗体缩放

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭方式
//        JButton Restart = new JButton("重新开始");
//        add(Restart);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);

                if(e.getButton()==1)//任何状态下可点击
                {
                    if(       e.getX()>795//GameComponents.offset+GameComponents.square_length*(GameComponents.map_w/2)
                            &&e.getX()<845//GameComponents.offset+GameComponents.square_length*(GameComponents.map_w/2)+GameComponents.square_length
                            &&e.getY()>45//GameComponents.offset
                            &&e.getY()<95)//GameComponents.offset+GameComponents.square_length)
                    {
                        gamePlay.RePlay();
                    }
                    GameComponents.Mouse_left=true;
                }
                if(e.getButton()==1&&!gamePlay.IfVictory()&&!gamePlay.IfDefeat())//只有没有胜利的时候或者没有失败的时候才可以操作
                {

                    GameComponents.Mouse_x=e.getX();
                    GameComponents.Mouse_y=e.getY();
//                    if(e.getX()>GameComponents.offset+GameComponents.square_length*(GameComponents.map_w/2)
//                       &&e.getX()<GameComponents.offset+GameComponents.square_length*(GameComponents.map_w/2)+GameComponents.square_length
//                       &&e.getY()>GameComponents.offset && e.getY()<GameComponents.offset+GameComponents.square_length)
//                    {
//                        gamePlay.RePlay();
//                    }
                    GameComponents.Mouse_left=true;
                }
                if(e.getButton()==3&&!gamePlay.IfVictory()&&!gamePlay.IfDefeat())
                {
                    GameComponents.Mouse_x=e.getX();
                    GameComponents.Mouse_y=e.getY();
                    GameComponents.Mouse_right=true;
                }
                if(gamePlay.IfDefeat()&&GameComponents.IfFirst)
                {
                    GameComponents.IfFirst=false;
                    //sql_server.update();
                    JOptionPane.showMessageDialog(null, "你输了");

                }
                if(gamePlay.IfVictory()&&GameComponents.IfFirst)
                {
                    GameComponents.score+=10;
                   // sql_server.update();
                    GameComponents.IfFirst=false;
                    JOptionPane.showMessageDialog(null, "你赢了");
                }

            }
        });
        addKeyListener(new KeyAdapter() {
            //当键盘按下时，会自此方法
            @Override
            public void keyPressed(KeyEvent e) {
                //键盘中的一个键都有一个编号

                if(e.getKeyChar()=='a'||e.getKeyChar()=='A')
                {
                    GameComponents.map_w=9;
                    GameComponents.map_h=9;
                    GameComponents.mine_count =10;
                    gamePlay.RePlay();

                }
                if(e.getKeyChar()=='b'||e.getKeyChar()=='B')
                {
                    GameComponents.map_w=16;
                    GameComponents.map_h=16;
                    GameComponents.mine_count =40;
                    gamePlay.RePlay();

                }
                if(e.getKeyChar()=='c'||e.getKeyChar()=='C')
                {
                    GameComponents.map_w=30;
                    GameComponents.map_h=15;
                    GameComponents.mine_count =99;
                    gamePlay.RePlay();
                }
            }
        });
        while (true)
    {
        repaint();
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

    @Override
    public void paint(Graphics g)
    {
        gamePlay.MouseLogic();
        //g.drawLine(0,0,400,400);
        FBO=this.createImage(width,height);//这里为解决闪动现象，采用双缓存技术
        Graphics RBO = FBO.getGraphics();
        drawBottomComponents.PaintLine(RBO);
        drawBottomComponents.PaintMine(RBO);
        drawBottomComponents.PaintNumber(RBO);
        drawTopComponents.PaintTop(RBO);//整合成一张图片
        g.drawImage(FBO,0,0,null);
    }

    public static void main(String[] args) {
        GameWindow w =new GameWindow();

        w.startup();

    }
}
