import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestArea {
    public static void main(String[] args) {
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(1920, 1080);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // 创建一个 5 行 10 列的文本区域
        final JTextArea textArea = new JTextArea("I am typing! ",50,60);
        // 设置自动换行
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        // 添加到内容面板
        panel.add(textArea);

        // 创建一个提交按钮，点击按钮获取输入文本
        JButton btn = new JButton("提交");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("提交: " + textArea.getText());
            }
        });
        panel.add(btn);

        jf.add(textArea);
        jf.setVisible(true);
    }
}
