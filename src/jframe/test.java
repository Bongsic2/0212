package jframe;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

import view.sounds.MusicBackGround;

public class test {

	private JFrame frame;
	private JTextField textField;
	ImageIcon rankBtn = new ImageIcon(
			"C:\\Users\\이름\\eclipse-workspace\\musicgameProject2-master\\src\\view\\buttonsGUI\\rank5.png");
	ImageIcon QuitBtn = new ImageIcon("C:\\Users\\이름\\eclipse-workspace\\musicgameProject2-master\\src\\view\\buttonsGUI\\QuitBtn1.png");
	ImageIcon QuitBtnMouseOver = new ImageIcon("C:\\Users\\이름\\eclipse-workspace\\musicgameProject2-master\\src\\view\\buttonsGUI\\QuitBtnMouseOver1.png");
	ImageIcon waitingRoomBtn = new ImageIcon("C:\\Users\\이름\\eclipse-workspace\\musicgameProject2-master\\src\\view\\buttonsGUI\\waitingBtn1.png");
	ImageIcon waitingRoomBtnMouserOver = new ImageIcon("C:\\Users\\이름\\eclipse-workspace\\musicgameProject2-master\\src\\view\\buttonsGUI\\waintRoomMouse11.png");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton endBtn = new JButton(QuitBtn);
		endBtn.setBounds(1003, 563, 200, 70);
		endBtn.setBorderPainted(false);
		endBtn.setContentAreaFilled(false);
		endBtn.setFocusPainted(false);
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
		frame.getContentPane().add(endBtn);

		JButton roomBtn = new JButton(waitingRoomBtn);
		roomBtn.setBounds(753, 563, 200, 70);
		frame.getContentPane().add(roomBtn);

		JList songList = new JList();
		songList.setBounds(753, 196, 450, 350);
		frame.getContentPane().add(songList);

		JButton rankbtn = new JButton(rankBtn);
		rankbtn.setBounds(36, 26, 520, 250);
		frame.getContentPane().add(rankbtn);


		textField = new JTextField();
		textField.setBounds(36, 300, 520, 340);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JList userList = new JList();
		userList.setBounds(753, 25, 450, 161);
		frame.getContentPane().add(userList);

		textField = new JTextField();
	}
}
