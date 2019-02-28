package com.kali.game.one;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * @author mahan.k.palavelli
 * 
 */
public class MindGame extends JFrame {

	private static final long serialVersionUID = 1L;
	final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	/*
	 * splitPane.setTopComponent(topButton);
	 * splitPane.setBottomComponent(bottomButton);
	 */

	/**
	 * Components Creation
	 */
	// GroupLayout groupLayout;
	JTextField scoreText, timerText;
	JLabel scoreLabel, timerLabel, imageLabel;
	JRadioButton countDownRadio;
	/**
	 * images path
	 */
	String SMILE_IMG_PATH = "src//main//java//com//kali//game//one//images//smile.gif";
	String SAD_IMG_PATH = "src/main/java/com/kali/game/one/images/sad.png";
	String RIGHT_IMG_PATH = "src/main/java/com/kali/game/one/images/right.jpg";
	String WRONG_IMG_PATH = "src/main/java/com/kali/game/one/images/wrong.jpg";
	static String USER_NAME = "Admin";
	static Map<String, String> KEY_VALUE ;
	static UtilClass util = new UtilClass();
	// src/main/java/com/kali/game/one/images
	int timerDigits = 0, score = 0;

	public MindGame() {
		// Nothing to do
	}

	public MindGame(final int selectedLevel, final List<Integer> buttonValues,
			final int transScore, final int gameOverTime) {
		/**
		 * Initializing
		 */
		timerDigits = gameOverTime;
		this.score = transScore;

		/**
		 * Panel activities
		 */
		// setContentPane(new JLabel(new
		// ImageIcon("C:\\Users\\mahan.k.palavelli\\Desktop\\Sample Images\\Tulips.jpg")));
		setTitle("All the Best");
		setResizable(false);
		setLayout(new FlowLayout());
		if(selectedLevel >= 4)
			setSize(250, 380);
		else
			setSize(250, 280);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		/**
		 * Registration of Components
		 */
		JPanel topPanel = new JPanel();
		// groupLayout = new GroupLayout(this);
		scoreLabel = new JLabel("Score:");
		timerLabel = new JLabel("Time left: ");

		scoreText = new JTextField(5);
		scoreText.setForeground(Color.BLUE);
		scoreText.setEditable(false);
		scoreText.setText(Integer.toString(transScore));

		timerText = new JTextField(5);
		timerText.setForeground(Color.red);
		timerText.setEditable(false);
		timerText.setText(Integer.toString(timerDigits));

		countDownRadio = new JRadioButton();
		countDownRadio.setEnabled(false);
		/*
		 * JPanel jcom = new JPanel(); groupLayout = new GroupLayout(jcom);
		 * jcom.setLayout(groupLayout);
		 * groupLayout.setAutoCreateContainerGaps(true);
		 * groupLayout.setAutoCreateGaps(true); GroupLayout.SequentialGroup
		 * vGroup = groupLayout.createSequentialGroup();
		 */

		imageLabel = new JLabel("");
		imageLabel.setSize(50, 50);
		changeImage(SMILE_IMG_PATH);

		/**
		 * Required Actions.
		 */
		ActionListener actTimerListner = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timerDigits--;
				changeImage(SMILE_IMG_PATH);
				timerText.setText(Integer.toString(timerDigits));
				if (timerDigits == 0) {
					/*if (score >= 0) {
						JOptionPane.showMessageDialog(null, USER_NAME
								+ " Your Score: " + score, "Time UP", 1);
					} else
						JOptionPane.showMessageDialog(null, "Fail ", "Time UP",
								JOptionPane.INFORMATION_MESSAGE,
								changeImage(SAD_IMG_PATH));*/
					((Timer) e.getSource()).stop();
					//timerDigits = gameOverTime;
					try {
						if(USER_NAME != null && !USER_NAME.equalsIgnoreCase("G=6.67") && !USER_NAME.equalsIgnoreCase("Admin"))
							saveScore(score, selectedLevel);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//System.exit(0);
					return;
				}
				if (timerDigits - 0 <= 10 && (timerDigits - 0) % 2 == 0) {
					countDownRadio.setBackground(Color.red);
				} else
					countDownRadio.setBackground(Color.lightGray);
			}
		};
		final Timer timer = new Timer(1000, actTimerListner);
		timer.start();
		if (buttonValues != null && buttonValues.size() != 0) {
			for (final Integer value : buttonValues) {
				final JButton button = new JButton(value.toString());
				// topPanel.addAtEnd(button);
				// splitPane.setTopComponent(button);
				add(button);
				ActionListener actListen = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(timerDigits == 0) {

							if (score >= 0) {
								JOptionPane.showMessageDialog(null, USER_NAME
										+ " Your Score: " + score, "Time UP", 1);
							} else
								JOptionPane.showMessageDialog(null, "Fail ", "Time UP",
										JOptionPane.INFORMATION_MESSAGE,
										changeImage(SAD_IMG_PATH));

							System.exit(0);
						}
						if (Collections.min(buttonValues) == value) {
							buttonValues.remove(value);
							score += 1;
							scoreText.setText((new Integer(score)).toString());
							button.setEnabled(false);
							button.setForeground(Color.gray);
							button.setBackground(Color.gray);
							changeImage(RIGHT_IMG_PATH);
							/*
							 * if(buttonValues.size() == 2) {
							 * JOptionPane.showMessageDialog
							 * (null,"Time up\n Your Score: "+score,"Error",2);
							 * }
							 */
							if (buttonValues.size() == 0) {
								setVisible(false);
								dispose();
								MindGame.newMindGame(selectedLevel, score,
										timerDigits);
							}
						} else {
							score -= 1;
							scoreText.setText((new Integer(score)).toString());
							changeImage(WRONG_IMG_PATH);
							if (buttonValues.size() < ((-1) * score))
								JOptionPane.showMessageDialog(null,
										"Your score would be <=0.",
										"Relax and Do", 1);
						}

					}

				};
				button.addActionListener(actListen);
			}
		}
		/**
		 * Add Components to Panel or Frame
		 */
		// splitPane.setTopComponent(topPanel);
		// addWindowListener(new WindowAdapter(){ public void
		// windowClosing(WindowEvent we){System.exit(0);}});
		JPanel bottomPanel = new JPanel();
		topPanel.add(scoreLabel);
		topPanel.add(scoreText);
		// topPanel.addAtEnd(statusRadioButton);
		topPanel.add(imageLabel);
		bottomPanel.add(timerLabel);
		bottomPanel.add(timerText);
		bottomPanel.add(countDownRadio);
		// bottomPanel.addAtEnd(imageLabel);
		splitPane.setTopComponent(topPanel);
		splitPane.setBottomComponent(bottomPanel);

		/*
		 * vGroup.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).
		 * addComponent
		 * (scoreLabel).addComponent(scoreText).addComponent(statusRadioButton
		 * ));
		 * vGroup.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE
		 * ).addComponent(timerLabel).addComponent(timerText));
		 * 
		 * groupLayout.setVerticalGroup(vGroup);
		 * splitPane.setBottomComponent(jcom); getContentPane().addAtEnd(splitPane);
		 */
		/*
		 * splitPane.setBottomComponent(scoreLabel);
		 * splitPane.setBottomComponent(scoreText);
		 * splitPane.setBottomComponent(timerLabel);
		 * splitPane.setBottomComponent(timerText);
		 */
		getContentPane().add(splitPane);
		/*
		 * addAtEnd(scoreLabel);addAtEnd(scoreText); addAtEnd(timerLabel);addAtEnd(timerText); //
		 * addAtEnd(statusRadioButton); // addAtEnd(imageLabel);
		 */
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String[] args) {
		newMindGame(1, 0, 50);
	}

	static void newMindGame(int selectedLevel, int transScore, int gameOverTime) {
		List<Integer> valueButtons = new CopyOnWriteArrayList<Integer>();
		Random r = new Random();
		int Low = 10;
		int High = 100;
		int R = r.nextInt(High - Low) + Low;
		/*if (selectedLevel == 1) {
			for (int i = 1; i <= 8; i++) {
				R = r.nextInt(High - Low) + Low;
				valueButtons.addAtEnd(R);
			}
		} else if (selectedLevel == 2) {
			for (int i = 1; i <= 12; i++) {
				R = r.nextInt(High - Low) + Low;
				valueButtons.addAtEnd(R);
			}
		} else {
			for (int i = 1; i <= 16; i++) {
				R = r.nextInt(High - Low) + Low;
				valueButtons.addAtEnd(R);
			}
		}*/
		
		
		switch(selectedLevel) {
		case 1: 
			for (int i = 1; i <= 8; i++) {
				R = r.nextInt(High - Low) + Low;
				valueButtons.add(R);
			}
			break;
		case 2: 
			for (int i = 1; i <= 12; i++) {
				R = r.nextInt(High - Low) + Low;
				valueButtons.add(R);
			}
			break;
		case 3:
			for (int i = 1; i <= 16; i++) {
				R = r.nextInt(High - Low) + Low;
				valueButtons.add(R);
			}
			break;
		case 4:
			for (int i = 1; i <= 20; i++) {
				R = r.nextInt(High - Low) + Low;
				valueButtons.add(R);
			}
			break;
		case 5:
			for (int i = 1; i <= 24; i++) {
				R = r.nextInt(High - Low) + Low;
				valueButtons.add(R);
			}
			break;
		case 6:
			for (int i = 1; i <= 28; i++) {
				R = r.nextInt(High - Low) + Low;
				valueButtons.add(R);
			}
			break;
		}
//		System.out.println(valueButtons);
		new MindGame(selectedLevel, valueButtons, transScore, gameOverTime);
	}

	private ImageIcon changeImage(String imagePath) {
		Image dimg = null;
		try {
			BufferedImage img = ImageIO.read(new File(imagePath));
			dimg = img.getScaledInstance(imageLabel.getWidth(),
					imageLabel.getHeight(), Image.SCALE_SMOOTH);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(dimg);
		imageLabel.setIcon(icon);
		return icon;
	}

	public void updateDetails(String name, Map<String,String> KEY_VALUE) {
		this.USER_NAME = name;
		this.KEY_VALUE = KEY_VALUE;
	}

	private void saveScore(int score, int selectedLevel) throws IOException {
		StringBuilder finalData = new StringBuilder();
		File scoreFile = new File("src/main/java/com/kali/game/one/score.txt");
		if (null != KEY_VALUE && KEY_VALUE.size() > 0) {
			if(KEY_VALUE.containsKey(USER_NAME))
				KEY_VALUE = util.updateOldInfoWithNewInfo(KEY_VALUE, USER_NAME+"^"+selectedLevel, (new Integer(score)).toString());
			else {
				finalData.append(USER_NAME + "=:" + score +"^"+selectedLevel+"\n");
//				userNameVsScore = util.stringBuilderToMap(finalData, userNameVsScore);
			}
			util.mapToStringBuilder(KEY_VALUE, finalData);
		}
		// if file doesnt exists, then create it
		else if (!scoreFile.exists()) {
			scoreFile.createNewFile();
			finalData.append(USER_NAME + "=:" + score +"^"+selectedLevel);
		}
		else {
			finalData.append(USER_NAME + "=:" + score +"^"+selectedLevel);
		}
		FileWriter fw = new FileWriter(scoreFile);
		fw.write(finalData.toString());
		fw.close();
	}
}
