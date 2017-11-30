import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class assignment  implements ActionListener
{
	JRadioButton buttonA, buttonB, buttonC, buttonD,invisible;
	JButton vote,result,resetButton;
	JPanel panel;
	JLabel labelResult,labelA, labelB, labelC, labelD, label;
	ButtonGroup group;
	String a,b,c,d;
	public static int voteA, voteB, voteC, voteD;
	JButton login = new JButton("Login");
	JPanel panel2 = new JPanel();
	JTextField u = new JTextField(15);
	JPasswordField pass  = new JPasswordField(15);
	JFrame frame2 = new JFrame("Login Authentication");
	JLabel username,password,first;
	String putusername,putpassword;
	Font font = new Font("Courier",Font.BOLD,20);
	assignment()
	{
		JFrame EVM = new JFrame("Electronic Voting App!");
		voteD = voteC = voteB = voteA = 0;
		a = "Narendra Modi";
		b = "Barack Obama";
		c = "Vladmir Putin";
		d = "Xi Jinping";
		panel = new JPanel();
		panel.setLayout(null);
		group = new ButtonGroup();
		label = new JLabel("!! Click Vote button to Submit your Vote !!",SwingConstants.CENTER);
        label.setFont(font);
        label.setOpaque(true);
        label.setBackground(new Color(204, 238, 241));
        label.setForeground(Color.RED);
        label.setPreferredSize(new Dimension(120, 40));
        label.setBounds(100,20,700,30);
        
        buttonA = new JRadioButton(a);
		buttonA.setForeground(Color.BLACK);
		buttonA.setFont(font);
		buttonA.setActionCommand("Aclicked");
		buttonA.setBounds(50,70,500,30);
		buttonB = new JRadioButton(b);
		buttonB.setForeground(Color.BLACK);
		buttonB.setFont(font);
		buttonB.setActionCommand("Bclicked");
		buttonB.setBounds(50,120,500,30);
		buttonC = new JRadioButton(c);
		buttonC.setForeground(Color.BLACK);
		buttonC.setFont(font);
		buttonC.setActionCommand("Cclicked");
		buttonC.setBounds(50,170,500,30);
		buttonD = new JRadioButton(d);
		buttonD.setForeground(Color.BLACK);
		buttonD.setFont(font);
		buttonD.setActionCommand("Dclicked");
		buttonD.setBounds(50,220,500,30);
		invisible = new JRadioButton("Invisible");
		invisible.setBounds(50,600,500,30);
		invisible.setFont(font);

		vote = new JButton("Vote");
		vote.setFont(font);
        vote.setBackground(Color.GRAY);
        vote.setForeground(Color.WHITE);
        vote.setBounds(180,300,200,30);

        labelResult = new JLabel("For Result Click On This Button.");
        labelResult.setFont(font);
        labelResult.setBounds(30,400,400,20);
        result = new JButton("Result");
        result.setBounds(50,450,200,30);
        result.setFont(font);
        resetButton = new JButton("Reset Votes");
        resetButton.setBounds(300,450,200,30);
        resetButton.setFont(font);
        group.add(buttonD); group.add(buttonC); group.add(buttonB); group.add(buttonA); group.add(invisible);
        panel.add(label);
		panel.add(buttonD); panel.add(buttonC); panel.add(buttonB); panel.add(buttonA);
		panel.add(vote); panel.add(result); panel.add(labelResult); panel.add(resetButton);
		vote.addActionListener(this);
		result.addActionListener(this);
		resetButton.addActionListener(this);
		EVM.add(panel);
		EVM.setSize(800,600);
		EVM.setLocationRelativeTo(null);
		EVM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EVM.setVisible(true);
	}
	public void  administrator()
	{
		String save = "Null" ;
		int max = voteA > (voteB > (voteC > voteD ? voteC : voteD) ? voteB : (voteC > voteD ? voteC : voteD)) ? voteA : (voteB > (voteC > voteD ? voteC : voteD) ? voteB : (voteC > voteD ? voteC : voteD));
		if(max == voteA)
			save =  a;
		else if(max == voteB)
			save = b;
		else if(max == voteC)
			save = c;
		else if(max == voteD)
			save = d;
		if(voteA == 0 && voteB == 0 && voteC == 0 && voteD ==0)
			JOptionPane.showMessageDialog(null, "No votes are registered yet");
		else
		JOptionPane.showMessageDialog(null,a + " :" + voteA+"\n"+ b + " :" +voteB+"\n" + c + " :" + voteC + "\n" + d + " :" + voteD + "\nCongratulations " +save +" Wins", "Result", 1);
	}
	public void adminlogin()
	{
		first = new JLabel("!! Please Login To See The Result !!");
		first.setFont(font);
        first.setOpaque(true);
        first.setBackground(new Color(204, 238, 241));
        first.setForeground(Color.RED);
        first.setPreferredSize(new Dimension(120, 40));
		username = new JLabel("Enter Username");
		password = new JLabel("Enter Password");
		frame2.setSize(500,300);
		frame2.setLocation(500,280);
		frame2.setLocationRelativeTo(null);
		panel2.setLayout (null);
		first.setBounds(30,20,500,20);
		u.setBounds(240,80,150,20);
		username.setBounds(80,80,150,20);
		pass.setBounds(240,120,150,20);
		password.setBounds(80,120,150,20);
		login.setBounds(200,160,80,20);
		panel2.add(first); panel2.add(login); panel2.add(u); panel2.add(pass); panel2.add(username); panel2.add(password); panel2.setBackground(Color.CYAN);
		frame2.add(panel2);
		frame2.setVisible(true);
		login.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==vote)
		{
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int n = JOptionPane.showConfirmDialog(null, "Are you sure and  want to Confirm Your Vote ?", "Confirmation Box", dialogButton);
			String command = group.getSelection().getActionCommand();
			if(n == JOptionPane.YES_OPTION)
			{
				if(command == "Aclicked"){
					voteA++;
					JOptionPane.showMessageDialog(null, "Thank You For Submitting Your Precious Vote");
				}
				else if(command == "Bclicked"){
					voteB++;
					JOptionPane.showMessageDialog(null, "Thank You For Submitting Your Precious Vote");
				}
				else if(command == "Cclicked"){
					voteC++;
					JOptionPane.showMessageDialog(null, "Thank You For Submitting Your Precious Vote");
				}
				else if(command == "Dclicked"){
					voteD++;
					JOptionPane.showMessageDialog(null, "Thank You For Submitting Your Precious Vote");
				}
				else
					JOptionPane.showMessageDialog(null, "Oops !! You Have Not Selected Any Candidate");
			}
			invisible.setSelected(true);
		}
		else if (e.getSource() == resetButton ){
			voteA = voteB = voteC = voteD = 0;
			JOptionPane.showMessageDialog(null,"Votes Reseted");			
		}
		else
		{
			adminlogin();
			if(e.getSource() == login){
				putusername = u.getText();
				putpassword = pass.getText();
				if(putusername.equals("Rahul") && putpassword.equals("Rahul@1122"))
				{
					administrator();
				}
				else if(!putusername.equals("Rahul") && !putpassword.equals("Rahul@1122"))
		 		{
					JOptionPane.showMessageDialog(null,"Wrong Password / Username");
				}
				u.setText("");
		    	pass.setText("");
		    }
		}
	}
	public static void main(String args[])
	{
		new assignment();
	}
}

