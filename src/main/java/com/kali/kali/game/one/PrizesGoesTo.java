package com.kali.kali.game.one;

import com.kali.game.one.UtilClass;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * @author mahan.k.palavelli
 * 
 */
public class PrizesGoesTo extends JFrame{

	static com.kali.game.one.UtilClass util = new com.kali.game.one.UtilClass();
	JButton showAllUsersScore, showOnlyPrizes;
	public PrizesGoesTo() {
		showAllUsersScore = new JButton("Show all users Score");
		showOnlyPrizes = new JButton("Prizes Distribution");
		add(showAllUsersScore);
		add(showOnlyPrizes);
		ActionListener actListner = new ActionListener()  {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == showAllUsersScore) {
					JOptionPane.showMessageDialog(null, "Under construcation");
				}
				else {
					setVisible(false);
					dispose();
					distributionPrizes();
				}
			}
		};
		showAllUsersScore.addActionListener(actListner);
		showOnlyPrizes.addActionListener(actListner);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(200, 150);
		setLayout(new FlowLayout());
		setVisible(true);
	}
	public static void main(String[] args) {
		new PrizesGoesTo();
	}

	public static void distributionPrizes() {

		try {
			Map<Integer, Map<String, String>> scoreTotalDetails = UtilClass.getDetailsOfScoreFile(new File(
							"src/main/java/com/kali/game/one/score.txt"));
			Map<String, String> userVsScore;
			StringBuilder strBuilder = new StringBuilder();
			if (scoreTotalDetails != null && scoreTotalDetails.size() > 0) {
				for (Map.Entry<Integer, Map<String, String>> entrySet : scoreTotalDetails.entrySet()) {
					strBuilder.append("Level "+entrySet.getKey()+":\n");
					userVsScore = entrySet.getValue();
					if (userVsScore != null && userVsScore.size() > 0) {
						strBuilder.append(""+prizes(userVsScore));
						strBuilder.append("\n");
					}
				}
			} else {
				strBuilder.append("No Data Found");
			}
			JOptionPane.showMessageDialog(null,new JTextArea(strBuilder.toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static StringBuilder prizes(Map<String, String> usersVsScore) {
		StringBuilder finalPrizes = new StringBuilder("");
		TreeSet<Integer> set = new TreeSet<Integer>();
		usersVsScore.keySet().stream().collect(Collectors.toSet());
		if (usersVsScore != null && usersVsScore.size() > 0) {
			Set<String> keySet = usersVsScore.keySet();
			Iterator itr = keySet.iterator();
			while (itr.hasNext()) {
				set.add(Integer.parseInt(usersVsScore.get(itr.next())));
			}
			itr = set.descendingIterator();
			int loop = 0;
			while (itr.hasNext() && loop < 3) {
				switch (loop) {
				case 0:
					finalPrizes.append("\t1st: ");
					break;
				case 1:
					finalPrizes.append("\n\t2nd: ");
					break;
				case 2:
					finalPrizes.append("\n\t3rd: ");
					break;
				default:
					break;
				}
				loop++;
				String str = itr.next().toString();
				if (usersVsScore.containsValue(str))
					for (Map.Entry<String, String> enteryMap : usersVsScore
							.entrySet()) {
						if (enteryMap.getValue().equalsIgnoreCase(str)) {
							finalPrizes.append(enteryMap.getKey() + "("+str+"), ");
						}
					}
			}
			//JOptionPane.showMessageDialog(null, finalPrizes);
		}
		return finalPrizes;
	}
}
