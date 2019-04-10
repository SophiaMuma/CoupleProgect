import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame {
	// Create three check boxes to control the display of message
	private JButton jbtRight = new JButton("开始做题");
	private JButton developer = new JButton("上传文件");
	private JCheckBox jchkCentered = new JCheckBox("有乘除法");
	private JCheckBox jchkBold = new JCheckBox("有括号");
	private JTextField n = new JTextField(8);
	private JTextField m1 = new JTextField(8);
	private JTextField m2 = new JTextField(8);
	private JTextField o = new JTextField(8);
	private JLabel label = new JLabel();
	private static JLabel label0 = new JLabel();
	private static JButton jbnext = new JButton("下一题");
	private static JButton jbsubmit = new JButton("完成");
	private int n1, m11, m22, o1, c = 0, b = 0;
	int flag0 = 0;
	int flag1 = 0;
	int flag2 = 0;
	int flag3 = 0;
	int flag4 = 0;
	static int flag6 = 0;
	ArrayList<String> list = new ArrayList<String>();
	static ArrayList<String> list0 = new ArrayList<String>();
	static int rightAnswer = 0;

	public static void main(String[] args) {
		GUI frame = new GUI();
		frame.setTitle("四则运算系统");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 450);
		frame.setVisible(true);
	}

	public GUI() {

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 2, 5, 5));
		p1.add(new JLabel("请输入题目数量[1,10000]："));
		p1.add(n);
		p1.add(new JLabel("请输入数字最小值[1,100]："));
		p1.add(m1);
		p1.add(new JLabel("请输入数字最大值[50,1000]："));
		p1.add(m2);
		p1.add(new JLabel("请输入运算符个数[1,10]："));
		p1.add(o);

		JPanel jpButtons = new JPanel();
		jpButtons.add(jbtRight);
		jpButtons.add(developer);
		jbtRight.setMnemonic('V');
		jbtRight.setToolTipText("开始做题");
		developer.setHorizontalAlignment(SwingConstants.CENTER);
		setLayout(new BorderLayout());
		add(jpButtons, BorderLayout.SOUTH);

		jchkCentered.setMnemonic('C');
		jchkBold.setMnemonic('B');

		JPanel jpCheckBoxes = new JPanel();
		jpCheckBoxes.setLayout(new GridLayout(3, 1));
		jpCheckBoxes.add(jchkCentered);
		jpCheckBoxes.add(jchkBold);
		add(jpCheckBoxes, BorderLayout.NORTH);
		add(p1, BorderLayout.CENTER);
		
		jchkCentered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = 1;
			}
		});
		jchkBold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b = 1;
			}
		});

		jbtRight.addActionListener(new ButtonListener());// 出题监听器
		developer.addActionListener(new MouseListener()); // 文件上传功能
	}

	private class MouseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			eventOnImport(new JButton());
		}

		private void eventOnImport(JButton jButton) {
			// TODO Auto-generated method stub
			
		}

	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				n1 = Integer.parseInt(n.getText());
				if (n1 <= 0 || n1 > 10000) {
					n.setText("输入数字错误，请输入0到10000的数字哦");
					return;
				}
				flag0 = 1;
			} catch (Exception a) {
				n.setText("不对哦，请重新输入数字哦");
			}
			try {
				m11 = Integer.parseInt(m1.getText());
				if (m11 <= 0 || m11 > 100) {
					m1.setText("输入数字错误，请输入0到100的数字哦");
					return;
				}
				flag1 = 1;
			} catch (Exception a) {
				m1.setText("不对哦，请重新输入数字哦");
			}
			try {
				m22 = Integer.parseInt(m2.getText());
				if (m22 < 50 || m22 > 1000) {
					m2.setText("输入数字错误，请输入50到1000的数字哦");
					return;
				}
				flag2 = 1;

			} catch (Exception a) {
				m2.setText("不对哦，请重新输入数字哦");
			}
			try {
				o1 = Integer.parseInt(o.getText());
				if (o1 <= 0 || o1 > 10) {
					o.setText("输入数字错误，请输入1到10的数字哦");
					return;
				}
				flag3 = 1;
			} catch (Exception a) {
				o.setText("不对哦，请重新输入数字哦");
			}

			if (flag0 == 1 && flag1 == 1 && flag2 == 1 && flag3 == 1) {
				final long t1 = Calendar.getInstance().getTimeInMillis(); // 获取开始时间
				JFrame TiMuFrame = new JFrame();
				TiMuFrame.setTitle("题目");
				TiMuFrame.setSize(700, 400);
				TiMuFrame.setLocationRelativeTo(null);
				TiMuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				TiMuFrame.setVisible(true);

				JPanel panel2 = new JPanel();
				final JTextField text = new JTextField(10);
				panel2.setLayout(new GridLayout(3, 2, 5, 5));
				label.setText(addProblem());
				panel2.add(label);
				panel2.add(new JLabel(""));
				panel2.add(new JLabel("请输入你的答案："));
				panel2.add(text);
				panel2.add(jbnext);
				panel2.add(jbsubmit);
				TiMuFrame.add(panel2);
				jbnext.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String question = label.getText();
						double result = Double.parseDouble(text.getText());
						String ifRight = "";
						String message = "";
						if (flag4 == 1) {
							if (Operation.sum == result) {
								ifRight = "正确";
								rightAnswer++;
							} else {
								ifRight = "错误";
							}
							message = question + "， " + "你的答案：" + result + "， " + "正确答案： " + Operation.sum + "， 结果： "
									+ ifRight;
						}
						if (flag4 == 0) {
							if (Operation1.sum == result) {
								ifRight = "正确";
								rightAnswer++;
							} else {
								ifRight = "错误";
							}
							message = question + "， " + "你的答案：" + result + "， " + "正确答案： " + Operation1.sum + "， 结果： "
									+ ifRight;
						}
						if (flag4 == -1) {
							if (Operation2.sum == result) {
								ifRight = "正确";
								rightAnswer++;
							} else {
								ifRight = "错误";
							}
							message = question + "， " + "你的答案：" + result + "， " + "正确答案： " + Operation2.sum + "， 结果： "
									+ ifRight + "。 ";
						}
						list.add(message);
						text.setText("");
						String answer = "";
						if (flag4 == 1) {
							answer = Operation.Operation(n1, m11, m22, c, o1);
						}
						if (flag4 == 0) {
							answer = Operation1.Operation(n1, m11, m22, c, o1);
						}
						if (flag4 == -1) {
							answer = Operation2.Operation(n1, m11, m22, c, o1);
						}
						// System.out.print(1);
						label.setText("题目：" + answer + "=");
						Font font = new Font(Font.DIALOG, Font.PLAIN, 20);
						label.setFont(font);
					}
				});

				jbsubmit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						long t2 = Calendar.getInstance().getTimeInMillis(); // 获取结束时间
						JFrame resultFrame = new JFrame();
						resultFrame.setTitle("题目");
						resultFrame.setSize(500, 500);
						resultFrame.setLocationRelativeTo(null);
						resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						resultFrame.setVisible(true);
						int size = list.size();

						JPanel panel = new JPanel();
						panel.add(new JLabel(
								 "  正确个数：" + rightAnswer +"做题总数： " + size + " " + "  用时(')：" + (t2 - t1) / 1000));
						setLayout(new GridLayout(100, 1, 5, 5));
						for (int i = 0; i < size; i++) {
							panel.add(new JLabel(list.get(i)));
						}
						resultFrame.add(panel);
					}
				});
			} else
				return;
			// c = 0;
			// b = 0;
		}
	}

	public String addProblem() {
		Font font = new Font(Font.DIALOG, Font.PLAIN, 20);
		label.setFont(font);
		String problem;
		if (b == 1 && c == 1) {
			flag4 = 1;
			problem = Operation.Operation(n1, m11, m22, c, o1);
		} else if (b == 0) {
			flag4 = 0;
			problem = Operation1.Operation(n1, m11, m22, c, o1);
		} else {
			flag4 = -1;
			problem = Operation2.Operation(n1, m11, m22, c, o1);
		}
		 label.setText(problem);
		return "题目：" + problem + "=";
	}
}