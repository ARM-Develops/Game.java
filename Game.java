import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Game extends JFrame{
private Task task;

//Create label for Choices and for result
    JLabel computerChoice,playerChoice,result,playermove,computermove;
//Create label for displaying score
    JLabel ComputerScore,PlayerScore;
    int Computer_Score=0;
    int Player_Score=0;

        ImageIcon image_rock, image_paper, image_scissor,image_rockC, image_paperC, image_scissorC;

        public void setup() {
            image_rock = new ImageIcon(new ImageIcon("rock.png").getImage().
                    getScaledInstance(80, 80, Image.SCALE_DEFAULT));
            image_paper = new ImageIcon(new ImageIcon("paper.png").getImage()
                    .getScaledInstance(80, 80, Image.SCALE_DEFAULT));
            image_scissor = new ImageIcon(new ImageIcon("scissors.png").getImage()
                    .getScaledInstance(80, 80, Image.SCALE_DEFAULT));
            image_rockC = new ImageIcon(new ImageIcon("rockC.png").getImage().
                    getScaledInstance(80, 80, Image.SCALE_DEFAULT));
            image_paperC = new ImageIcon(new ImageIcon("paperC.png").getImage()
                    .getScaledInstance(80, 80, Image.SCALE_DEFAULT));
            image_scissorC = new ImageIcon(new ImageIcon("scissorsC.png").getImage()
                    .getScaledInstance(80, 80, Image.SCALE_DEFAULT));

//Create labels
            JLabel score=new JLabel("ScoreBoard");
            score.setBounds(500,0,100,100);

            ComputerScore=new JLabel();
            ComputerScore.setText("Computer : 0");
            ComputerScore.setBounds(500,15,100,100);

            PlayerScore=new JLabel();
            PlayerScore.setText("Player: 0");
            PlayerScore.setBounds(500,30,100,100);

            playerChoice=new JLabel();
            playerChoice.setHorizontalTextPosition(JLabel.CENTER);
            playerChoice.setVerticalTextPosition(JLabel.BOTTOM);
            playerChoice.setBounds(100,120,100,100);
            playermove=new JLabel();
            playermove.setText("Your choice ");
            playermove.setBounds(30,120,100,100);

            computerChoice=new JLabel();
            computerChoice.setHorizontalTextPosition(JLabel.CENTER);
            computerChoice.setVerticalTextPosition(JLabel.BOTTOM);
            computerChoice.setBounds(350,120,100,100);
            computermove=new JLabel();
            computermove.setText("Computer choice ");
            computermove.setBounds(450,120,100,100);

            result=new JLabel();
            result.setFont(new Font("Serif",Font.BOLD,20));
            result.setBounds(220,120,100,100);

            JLabel label_rock = new JLabel();
            label_rock.setText("Rock");
            label_rock.setIcon(image_rock); //set icon
            label_rock.setHorizontalTextPosition(JLabel.CENTER);
            label_rock.setVerticalTextPosition(JLabel.BOTTOM);
            label_rock.setBounds(100, 400, 100, 100);

            JLabel label_paper = new JLabel();
            label_paper.setText("Paper");
            label_paper.setIcon(image_paper); //set icon
            label_paper.setHorizontalTextPosition(JLabel.CENTER);
            label_paper.setVerticalTextPosition(JLabel.BOTTOM);
            label_paper.setBounds(250, 400, 100, 100);

            JLabel label_scissor = new JLabel();
            label_scissor.setText("Scissor");
            label_scissor.setIcon(image_scissor); //set icon
            label_scissor.setHorizontalTextPosition(JLabel.CENTER);
            label_scissor.setVerticalTextPosition(JLabel.BOTTOM);
            label_scissor.setBounds(400, 400, 100, 100);

//Add MouseListener to Labels
            label_rock.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
//call calculate method
                    calculate(label_rock.getText());
                }
            });
            label_paper.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
//call calculate method
                    calculate(label_paper.getText());
                }
            });
            label_scissor.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
//call calculate method
                    calculate(label_scissor.getText());
                }
            });

//Add components in frame
            add(label_rock);
            add(label_paper);
            add(label_scissor);
            add(computerChoice);
            add(playerChoice);
            add(playermove);
            add(computermove);
            add(result);
            add(score);
            add(ComputerScore);
            add(PlayerScore);
            setLayout(null);



        }
    public void calculate(String player){
            String[] list={"Rock","Paper","Scissor"};
            int random_choice=(int)((Math.random()*10)%3); //for computer choices

            String computer=list[random_choice];

//Display computer choice on frame
        computerChoice.setText(computer);
        if(random_choice==0){
            computerChoice.setIcon(image_rockC);
        }
        else if(random_choice==1)
        {
            computerChoice.setIcon(image_paperC);
        }
        else{
            computerChoice.setIcon(image_scissorC);
        }



//Logic
        String res;
        if(player.equals(computer))
        {
            res="Draw";
        }
    else if(player.equals("Rock")) {

            if (computer.equals("Paper")) {
                res = "You Lose..";

                Computer_Score++;
            } else {
                res = "You Won!";
                Player_Score++;
            }
        }
    else if (player.equals("Paper")) {
            if (computer.equals("Scissor")) {
                res = "You Lose..";
                Computer_Score++;
            } else {
                res = "You Won!";
                Player_Score++;
            }
        }
        else
        {
                if (computer.equals("Rock"))
                {
                        res="You Lose..";
                        Computer_Score++;
                }
                    else
                    {
                        res="You Win!";
                        Player_Score++;
                    }
                }

//Display player choice on frame

        playerChoice.setText(player);
        if(player.equals("Rock")){
            playerChoice.setIcon(image_rock);
        }
        else if(player.equals("Paper"))
        {
            playerChoice.setIcon(image_paper);
        }
        else{
            playerChoice.setIcon(image_scissor);
        }
                result.setText(res);
                PlayerScore.setText("Player: "+Player_Score);
                ComputerScore.setText("Computer:"+Computer_Score);


}
    public static void main(String[] args) { //create frame


        Game g = new Game();
        g.setTitle("ROCK PAPER SCISSOR");
        g.setBounds(200, 200, 600, 600);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.getContentPane().setBackground(Color.WHITE);
        g.setup();
        g.setResizable(false);
        g.setVisible(true);



    }
    private class Task extends Thread{

            public void run(){
                String[] RPS={"Rock","Paper","Scissor"};
                for(int i=0;i<3;i++){
                    System.out.println(i);
                }
                try{
                    Thread.sleep(1000);
                }   catch(InterruptedException e){
                    e.printStackTrace();
                }

            }
    }
}