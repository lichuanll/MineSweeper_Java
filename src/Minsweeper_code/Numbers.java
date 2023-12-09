package Minsweeper_code;

public class Numbers {
    public Numbers()
    {

    }
    //Mines mines=new Mines();
    void SetupNumber()
    {


        for(int i = 0; i< GameComponents.mine_count; i++)
        {
            if(GameComponents.Map[Mines.mines_x[i]+1][Mines.mines_y[i]]!=-1)
                GameComponents.Map[Mines.mines_x[i]+1][Mines.mines_y[i]]+=1;

            if(GameComponents.Map[Mines.mines_x[i]-1][Mines.mines_y[i]]!=-1)
                GameComponents.Map[Mines.mines_x[i]-1][Mines.mines_y[i]]+=1;

            if(GameComponents.Map[Mines.mines_x[i]][Mines.mines_y[i]-1]!=-1)
                GameComponents.Map[Mines.mines_x[i]][Mines.mines_y[i]-1]+=1;

            if(GameComponents.Map[Mines.mines_x[i]][Mines.mines_y[i]+1]!=-1)
                GameComponents.Map[Mines.mines_x[i]][Mines.mines_y[i]+1]+=1;

            if(GameComponents.Map [Mines.mines_x[i]+1][Mines.mines_y[i]+1]!=-1)
                GameComponents.Map[Mines.mines_x[i]+1][Mines.mines_y[i]+1]+=1;

            if(GameComponents.Map [Mines.mines_x[i]+1][Mines.mines_y[i]-1]!=-1)
                GameComponents.Map[Mines.mines_x[i]+1][Mines.mines_y[i]-1]+=1;

            if(GameComponents.Map [Mines.mines_x[i]-1][Mines.mines_y[i]+1]!=-1)
                GameComponents.Map[Mines.mines_x[i]-1][Mines.mines_y[i]+1]+=1;

            if(GameComponents.Map [Mines.mines_x[i]-1][Mines.mines_y[i]-1]!=-1)
                GameComponents.Map[Mines.mines_x[i]-1][Mines.mines_y[i]-1]+=1;
        }
    }
}
