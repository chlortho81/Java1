/**
 * @ MakePayrollFileHW.java
 *
 * @Wei Lin
 * @CIT-239 JAVA BHCC
 * @Version 1.00.0 2009-2-21
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class MakePayrollFileHW extends Frame implements ActionListener {

	private TextField RecID_F, Name_F, SocSec_F, Hours_F, Rate_F;

	private Button enter, done;

	private DataOutputStream print;

	public MakePayrollFileHW() {

		super("Payroll Data inserter");

		try {
			print = new DataOutputStream(new FileOutputStream("Payroll.dat"));
		} // try
		catch (IOException e) {
			System.err.println("Could not open a file!!\n" + e.toString());
			System.exit(1);
		} // catch

		setSize(400, 300);
		setResizable(false);
		setLayout(new GridLayout(6, 2));

		add(new Label("Employee ID:"));

		RecID_F = new TextField();
		add(RecID_F);

		add(new Label("Name:"));
		Name_F = new TextField();
		add(Name_F);

		add(new Label("S.S #:"));
		SocSec_F = new TextField();
		add(SocSec_F);

		add(new Label("Hours"));
		Hours_F = new TextField();
		add(Hours_F);

		add(new Label("Rate"));
		Rate_F = new TextField();
		add(Rate_F);

		enter = new Button("ENTER");
		enter.addActionListener(this);
		enter.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					addsource();
			} // keyPressed
		}/*KeyAdapter*/);
		add(enter);

		done = new Button("FINISH");
		done.addActionListener(this);
		done.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					try {
						print.close();
					} // try
					catch (IOException io) {
						System.err.println("Fial to close File!\n"
								+ io.toString());
						System.exit(1);
					} // catch
				System.exit(0);
			} // KeyAdapter
		}/*keyPressed*/);
		add(done);

		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			} // windowClosing
		}/*WindowAdapter*/);
	} // MakePayrollFile

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enter)
			addsource();
		if (e.getSource() == done) {
			try {
				print.close();
			} // try
			catch (IOException io) {
				System.err.println("Fial to close File!\n" + io.toString());
				System.exit(1);
			} // catch
			System.exit(0);
		} // if

	} // actionPerformed

	public void addsource() {
		int ID = 0;
		Double h, r;

		if (!RecID_F.getText().equals("")) {
			try {
				ID = Integer.parseInt(RecID_F.getText());
				if (ID > 0) {
					print.writeInt(ID);
					print.writeUTF(Name_F.getText());
					print.writeUTF(SocSec_F.getText());

					h = new Double(Hours_F.getText());
					print.writeDouble(h.doubleValue());

					r = new Double(Rate_F.getText());
					print.writeDouble(r.doubleValue());
				} // if

				RecID_F.setText("");
				Name_F.setText("");
				SocSec_F.setText("");
				Hours_F.setText("");
				Rate_F.setText("");
			} // try
			catch (NumberFormatException e) {
				System.err.println("The Account Number must be integer.");
			} // catch
			catch (IOException e) {
				System.err.println("Error in data Entering!\n" + e.toString());
				System.exit(1);
			} // catch
		} // if
	} // addsource

	public static void main(String args[]) {
		new MakePayrollFileHW();
	} // main
} // MakePayrollFileHW
