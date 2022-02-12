package jframe;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

import music.MusicInfo;
import view.sounds.MusicBackGround;

public class JFRAME extends JFrame {
	private JFrame frame;
	MusicInfo musicInfo;
	ImageIcon QuitBtn = new ImageIcon(
			"../LineNo5_mh/src/view/buttonsGUI/QuitBtn1.png");
	ImageIcon QuitBtnMouseOver = new ImageIcon(
			"../LineNo5_mh/src/view/buttonsGUI/QuitBtnMouseOver1.png");
	ImageIcon waitingRoomBtn = new ImageIcon(
			"../LineNo5_mh/src/view/buttonsGUI/waitingBtn1.png");
	ImageIcon waitingRoomBtnMouserOver = new ImageIcon(
			"../LineNo5_mh/src/view/buttonsGUI/waintRoomMouse11.png");
	public static MusicBackGround introMusic = new MusicBackGround("/view/sounds/introMusic.mp3", true);
	ArrayList<MusicInfo> list;
	public static String a[] = new String[10];
	public static String b[] = new String[10];

	public JFRAME() {

	}

	public JFRAME(ArrayList<MusicInfo> listInfo) {
		this.list = listInfo;
		introMusic.start();
		initialize();
		getList();
		System.out.println(list.toString());
	}

	public void getList() {
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i).getSong() + "       " + list.get(i).getSinger();
			b[i] = list.get(i).getUrl();
		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel BigLabel = new JLabel(" ");
		BigLabel.setIcon(new ImageIcon(
				"../LineNo5_mh/src/view/playBackground.jpg"));
		BigLabel.setBounds(0, 0, 1266, 663);
		frame.getContentPane().add(BigLabel);
		BigLabel.setLayout(null);

		JButton roomBtn = new JButton(waitingRoomBtn);
		BigLabel.add(roomBtn);
		roomBtn.setBounds(734, 551, 232, 78);
		roomBtn.setBorderPainted(false);
		roomBtn.setContentAreaFilled(false);
		roomBtn.setFocusPainted(false);

		JButton endBtn = new JButton(QuitBtn);
		BigLabel.add(endBtn);
		endBtn.setBounds(1005, 551, 232, 78);
		endBtn.setBorderPainted(false);
		endBtn.setContentAreaFilled(false);
		endBtn.setFocusPainted(false);

		JLabel rank1 = new JLabel("1등");
		rank1.setIcon(
				new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/1remove.png"));
		rank1.setBounds(50, 40, 50, 50);
		BigLabel.add(rank1);

		JLabel rank2 = new JLabel("2등");
		rank2.setIcon(
				new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/2remove.png"));
		rank2.setBounds(50, 100, 50, 50);
		BigLabel.add(rank2);

		JLabel rank3 = new JLabel("3등");
		rank3.setIcon(
				new ImageIcon("../LineNo5_mh/src/view/buttonsGUI/3remove.png"));
		rank3.setBounds(50, 160, 50, 50);
		BigLabel.add(rank3);

		JList jlist = new JList(a);
		jlist.setFont(new Font("굴림", Font.PLAIN, 20));
		jlist.setBounds(750, 232, 460, 310);

		jlist.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int index = jlist.locationToIndex(e.getPoint());
				if (e.getClickCount() == 2) {
					try {
						Desktop.getDesktop().browse(new URI(b[index]));
					} catch (Exception e1) {

						e1.printStackTrace();

					}
				}
			}
		});
		BigLabel.add(jlist);

		JTextArea chatArea = new JTextArea();
		chatArea.setBounds(55, 290, 580, 345);
		BigLabel.add(chatArea);

		endBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				try {
					Thread.sleep(100);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				endBtn.setIcon(QuitBtnMouseOver);
				endBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				endBtn.setIcon(QuitBtn);
				endBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		roomBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				try {
					Thread.sleep(100);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				roomBtn.setIcon(waitingRoomBtnMouserOver);
				roomBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				roomBtn.setIcon(waitingRoomBtn);
				roomBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

	}

	public static void main(String[] args) {
		new JFRAME();
	}
}
