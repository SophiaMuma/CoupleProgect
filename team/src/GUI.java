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
	private JButton jbtRight = new JButton("��ʼ����");
	private JButton developer = new JButton("�ϴ��ļ�");
	private JCheckBox jchkCentered = new JCheckBox("�г˳���");
	private JCheckBox jchkBold = new JCheckBox("������");
	private JTextField n = new JTextField(8);
	private JTextField m1 = new JTextField(8);
	private JTextField m2 = new JTextField(8);
	private JTextField o = new JTextField(8);
	private JLabel label = new JLabel();
	private static JLabel label0 = new JLabel();
	private static JButton jbnext = new JButton("��һ��");
	private static JButton jbsubmit = new JButton("���");
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
		frame.setTitle("��������ϵͳ");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 450);
		frame.setVisible(true);
	}

	public GUI() {

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 2, 5, 5));
		p1.add(new JLabel("��������Ŀ����[1,10000]��"));
		p1.add(n);
		p1.add(new JLabel("������������Сֵ[1,100]��"));
		p1.add(m1);
		p1.add(new JLabel("�������������ֵ[50,1000]��"));
		p1.add(m2);
		p1.add(new JLabel("���������������[1,10]��"));
		p1.add(o);

		JPanel jpButtons = new JPanel();
		jpButtons.add(jbtRight);
		jpButtons.add(developer);
		jbtRight.setMnemonic('V');
		jbtRight.setToolTipText("��ʼ����");
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

		jbtRight.addActionListener(new ButtonListener());// ���������
		developer.addActionListener(new MouseListener()); // �ļ��ϴ�����
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
					n.setText("�������ִ���������0��10000������Ŷ");
					return;
				}
				flag0 = 1;
			} catch (Exception a) {
				n.setText("����Ŷ����������������Ŷ");
			}
			try {
				m11 = Integer.parseInt(m1.getText());
				if (m11 <= 0 || m11 > 100) {
					m1.setText("�������ִ���������0��100������Ŷ");
					return;
				}
				flag1 = 1;
			} catch (Exception a) {
				m1.setText("����Ŷ����������������Ŷ");
			}
			try {
				m22 = Integer.parseInt(m2.getText());
				if (m22 < 50 || m22 > 1000) {
					m2.setText("�������ִ���������50��1000������Ŷ");
					return;
				}
				flag2 = 1;

			} catch (Exception a) {
				m2.setText("����Ŷ����������������Ŷ");
			}
			try {
				o1 = Integer.parseInt(o.getText());
				if (o1 <= 0 || o1 > 10) {
					o.setText("�������ִ���������1��10������Ŷ");
					return;
				}
				flag3 = 1;
			} catch (Exception a) {
				o.setText("����Ŷ����������������Ŷ");
			}

			if (flag0 == 1 && flag1 == 1 && flag2 == 1 && flag3 == 1) {
				final long t1 = Calendar.getInstance().getTimeInMillis(); // ��ȡ��ʼʱ��
				JFrame TiMuFrame = new JFrame();
				TiMuFrame.setTitle("��Ŀ");
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
				panel2.add(new JLabel("��������Ĵ𰸣�"));
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
								ifRight = "��ȷ";
								rightAnswer++;
							} else {
								ifRight = "����";
							}
							message = question + "�� " + "��Ĵ𰸣�" + result + "�� " + "��ȷ�𰸣� " + Operation.sum + "�� ����� "
									+ ifRight;
						}
						if (flag4 == 0) {
							if (Operation1.sum == result) {
								ifRight = "��ȷ";
								rightAnswer++;
							} else {
								ifRight = "����";
							}
							message = question + "�� " + "��Ĵ𰸣�" + result + "�� " + "��ȷ�𰸣� " + Operation1.sum + "�� ����� "
									+ ifRight;
						}
						if (flag4 == -1) {
							if (Operation2.sum == result) {
								ifRight = "��ȷ";
								rightAnswer++;
							} else {
								ifRight = "����";
							}
							message = question + "�� " + "��Ĵ𰸣�" + result + "�� " + "��ȷ�𰸣� " + Operation2.sum + "�� ����� "
									+ ifRight + "�� ";
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
						label.setText("��Ŀ��" + answer + "=");
						Font font = new Font(Font.DIALOG, Font.PLAIN, 20);
						label.setFont(font);
					}
				});

				jbsubmit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						long t2 = Calendar.getInstance().getTimeInMillis(); // ��ȡ����ʱ��
						JFrame resultFrame = new JFrame();
						resultFrame.setTitle("��Ŀ");
						resultFrame.setSize(500, 500);
						resultFrame.setLocationRelativeTo(null);
						resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						resultFrame.setVisible(true);
						int size = list.size();

						JPanel panel = new JPanel();
						panel.add(new JLabel(
								 "  ��ȷ������" + rightAnswer +"���������� " + size + " " + "  ��ʱ(')��" + (t2 - t1) / 1000));
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
		return "��Ŀ��" + problem + "=";
	}
}