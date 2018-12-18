import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//还要改一个字号，再把内容和文本框联系起来
public class Index extends JFrame{

    private JSplitPane splitPane;
    private JSplitPane lsplitPane;
    private JSplitPane rsplitPane;

    private JMenuBar menuBar;

    private JMenu menu_file;
    private JMenu menu_edit;
    private JMenu menu_about;

    private JMenuItem item_new_file;
    private JMenuItem item_open_file;
    private JMenuItem item_exit;

    private JTextArea textarea;
    private JTextArea parse_log;
    private JTextArea lexer_log;
    private JTextArea console;

    private final String code = "Here are my codes.";

    public Index(){

        this.setTitle("CMM解释器");
        this.setSize(1280,720);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //代码显示区
        textarea = new JTextArea();
        textarea.append(code);
        textarea.setLineWrap(true);
        //控制台
        console = new JTextArea("This is a console.");
        console.setLineWrap(true);
        //词法分析结果
        lexer_log = new JTextArea("Here are lexer results.");
        console.setLineWrap(true);
        //语法分析结果
        parse_log = new JTextArea("Here are parse results.");

        lsplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        lsplitPane.setLeftComponent(textarea);
        lsplitPane.setRightComponent(console);
        lsplitPane.setDividerLocation(3*this.getHeight()/5);

        rsplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        rsplitPane.setLeftComponent(lexer_log);
        rsplitPane.setRightComponent(parse_log);
        rsplitPane.setDividerLocation(this.getHeight()/2);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(4*this.getWidth()/5);
        splitPane.setLeftComponent(lsplitPane);
        splitPane.setRightComponent(rsplitPane);



        menuBar = new JMenuBar();

        menu_file = new JMenu("文件");
        item_new_file = new JMenuItem("新建");
        item_open_file = new JMenuItem("打开");
        item_new_file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOpenDialog(textarea,textarea);
            }
        });
        item_exit = new JMenuItem("退出");
        menu_file.add(item_new_file);
        menu_file.add(item_open_file);
        menu_file.add(item_exit);

        menu_edit = new JMenu("编辑");
        menu_about = new JMenu("关于");

        menuBar.add(menu_file);
        menuBar.add(menu_edit);
        menuBar.add(menu_about);


        this.setJMenuBar(menuBar);
        this.add(splitPane);
    }

    private void showOpenDialog(Component parent, JTextArea textarea){
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File("\\."));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);

        fileChooser.setFileFilter(new FileNameExtensionFilter("txt"));

        int result = fileChooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try {
                Scanner scanner = new Scanner(file);
                if (scanner.hasNext()){
                    textarea.append(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Index index = new Index();
        index.setVisible(true);
    }
}
