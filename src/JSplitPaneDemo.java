import java.awt.BorderLayout;

import javax.swing.*;

public class JSplitPaneDemo extends JFrame {

    private static final long serialVersionUID = -3418853823231348095L;

    public JSplitPaneDemo() {

        /*setTitle("分割面板");
        setBounds(100, 100, 500, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSplitPane hSplitPane = new JSplitPane();
        hSplitPane.setDividerLocation(40);
        getContentPane().add(hSplitPane, BorderLayout.CENTER);
        hSplitPane.setLeftComponent(new JLabel("    1"));
        hSplitPane.setRightComponent(new JLabel("    2"));

        JSplitPane vSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        vSplitPane.setLeftComponent(new JLabel("    3"));
        vSplitPane.setRightComponent(new JLabel("    4"));
        vSplitPane.setDividerLocation(30);
        vSplitPane.setDividerSize(8);
        vSplitPane.setOneTouchExpandable(true);
        vSplitPane.setContinuousLayout(true);
        hSplitPane.setRightComponent(vSplitPane);*/
    }

    public static void main(String[] args) {
        /*// TODO Auto-generated method stub
        JSplitPaneDemo instance = new JSplitPaneDemo();
        instance.setVisible(true);*/

        JFrame jFrame = new JFrame("分割试验");
        jFrame.setSize(1920, 1080);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JSplitPane lSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        lSplitPane.setLeftComponent(new JLabel("3"));
        lSplitPane.setRightComponent(new JLabel("4"));
        lSplitPane.setDividerLocation(3*jFrame.getHeight()/5);

        JSplitPane rSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        rSplitPane.setLeftComponent(new JLabel("词法分析"));
        rSplitPane.setRightComponent(new JLabel("语法分析"));
        rSplitPane.setDividerLocation(jFrame.getHeight()/2);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(4*jFrame.getWidth()/5);
        splitPane.setLeftComponent(lSplitPane);
        splitPane.setRightComponent(rSplitPane);



        jFrame.add(splitPane);
        //jFrame.add(rSplitPane);
        jFrame.setVisible(true);
    }

}
