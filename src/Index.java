import javax.swing.*;

public class Index extends JFrame{

    private JSplitPane splitPane;
    private JSplitPane lsplitPane;
    private JSplitPane rsplitPane;

    public Index(){
        lsplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        lsplitPane.setLeftComponent(new JLabel("3"));
        lsplitPane.setRightComponent(new JLabel("4"));
        lsplitPane.setDividerLocation(3*this.getHeight()/5);

        rsplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        rsplitPane.setLeftComponent(new JLabel("词法分析"));
        rsplitPane.setRightComponent(new JLabel("语法分析"));
        rsplitPane.setDividerLocation(this.getHeight()/2);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(4*this.getWidth()/5);
        splitPane.setLeftComponent(lsplitPane);
        splitPane.setRightComponent(rsplitPane);

        this.add(splitPane);
    }
}
