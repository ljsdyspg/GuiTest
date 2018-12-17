import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class MyFrame extends JFrame{

    private JTextField jTextField;
    private JLabel jLabel;

    public MyFrame(int random){
        jTextField = new JTextField();
        jLabel = new JLabel("输入一个1000以内的整数");

        this.setLayout(new BorderLayout());
        this.add(jTextField, BorderLayout.NORTH);
        this.add(jLabel, BorderLayout.CENTER);
        this.add(new SouthPanel(), BorderLayout.SOUTH);

        this.setSize(500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public class SouthPanel extends JPanel implements ActionListener{
        private JButton guess;
        private JButton restart;
        private JButton exit;
        private int random;

        public SouthPanel(){
            guess = new JButton("guess");
            restart = new JButton("restart");
            exit = new JButton("exit");

            this.setLayout(new GridLayout(1,3));
            this.add(guess);
            this.add(restart);
            this.add(exit);

            guess.addActionListener(this);
            restart.addActionListener(this);
            exit.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            //获取监听事件的源
            JButton btn = (JButton) e.getSource();

            //判断源，然后处理监听事件
            if (btn == guess){
                //判断用户输入数字的大小
                System.out.println("====>"+random);
                if (Integer.parseInt(jTextField.getText()) > random){
                    jLabel.setText("老兄,你猜的数字太大啦!");
                    jTextField.setText("");
                } else if (Integer.parseInt(jTextField.getText()) < random){
                    jLabel.setText("老兄,你猜的数字太小啦!");
                    jTextField.setText("");
                } else {
                    jLabel.setText("老兄,恭喜你中奖啦!");
                    //使按钮失效
                    guess.setEnabled(false);
                }
            } else if (btn == restart){
                //随机生成一个1000内的数字
                random = (int) (Math.random()*1000);
                //设置标签
                jLabel.setText("请输入一个1000以内的整数");
                //使得"猜"按钮有效
                guess.setEnabled(true);
            } else if (btn == exit){

                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        int random  = (int)(Math.random()*1000);
        MyFrame frame = new MyFrame(random);
    }

}

