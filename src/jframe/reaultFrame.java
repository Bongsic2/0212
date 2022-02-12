package jframe;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

import music.MusicInfo;
import view.sounds.MusicBackGround;

public class reaultFrame {
	MusicInfo musicInfo;
	private JFrame frame;
	// reaultFrame window = new reaultFrame();
	ImageIcon QuitBtn = new ImageIcon(
			"C:\\Users\\이름\\eclipse-workspace\\musicgameProject2-master\\src\\view\\buttonsGUI\\QuitBtn1.png");
	ImageIcon QuitBtnMouseOver = new ImageIcon(
			"C:\\Users\\이름\\eclipse-workspace\\musicgameProject2-master\\src\\view\\buttonsGUI\\QuitBtnMouseOver1.png");
	ImageIcon waitingRoomBtn = new ImageIcon(
			"C:\\Users\\이름\\eclipse-workspace\\musicgameProject2-master\\src\\view\\buttonsGUI\\waitingBtn1.png");
	ImageIcon waitingRoomBtnMouserOver = new ImageIcon(
			"C:\\Users\\이름\\eclipse-workspace\\musicgameProject2-master\\src\\view\\buttonsGUI\\waintRoomMouse11.png");
	public static MusicBackGround introMusic = new MusicBackGround("/view/sounds/introMusic.mp3", true);
	ArrayList<MusicInfo> list;
	// 임의의 배열 저장

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					reaultFrame window = new reaultFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param listInfo
	 * @param listInfo
	 */
	public reaultFrame() {

	}

	public reaultFrame(ArrayList<MusicInfo> listInfo) {
		this.list = listInfo;
		introMusic.start();
		initialize();
		System.out.println(list);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		EventQueue.invokeLater(new Runnable() {
//
//			public void run() {
//				try {				
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel BigLabel = new JLabel(" ");
		BigLabel.setIcon(new ImageIcon(
				"C:\\Users\\이름\\eclipse-workspace\\musicgameProject2-master\\src\\view\\playBackground.jpg"));
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
				new ImageIcon("C:\\Users\\이름\\eclipse-workspace\\LineNo5_mh\\src\\view\\buttonsGUI\\1remove.png"));
		rank1.setBounds(50, 40, 50, 50);
		BigLabel.add(rank1);

		JLabel rank2 = new JLabel("2등");
		rank2.setIcon(
				new ImageIcon("C:\\Users\\이름\\eclipse-workspace\\LineNo5_mh\\src\\view\\buttonsGUI\\2remove.png"));
		rank2.setBounds(50, 100, 50, 50);
		BigLabel.add(rank2);

		JLabel rank3 = new JLabel("3등");
		rank3.setIcon(
				new ImageIcon("C:\\Users\\이름\\eclipse-workspace\\LineNo5_mh\\src\\view\\buttonsGUI\\3remove.png"));
		rank3.setBounds(50, 160, 50, 50);
		BigLabel.add(rank3);

		// ArrayList<String> songRandomIntList = songRandom.songRandomIntList;
		// ArrayList<MusicInfo> listInfo = ArrayList<MusicInfo>;
		JList list = new JList();
		list.setFont(new Font("굴림", Font.PLAIN, 20));
		list.setBounds(750, 232, 460, 310);
		BigLabel.add(list);

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
//	System.out.println(list);
	}
}
