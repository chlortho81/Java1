/**
 * @ ReadPayrollFileHW.java
 *
 * @Wei Lin
 * @CIT-239 JAVA BHCC
 * @Version 1.00.0 2009-2-21
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class EmpInfo {
	int ID;
	String name;
	String SocS;
	double hours;
	double rate;

	EmpInfo(String name, String SocS, double h, double r) {
		this.name = name;
		this.SocS = SocS;
		hours = h;
		rate = r;
	} // default EmpInfo constructor

	EmpInfo(String ID, String name, String SocS, String hours, String rate) {
		try {
			this.ID = Integer.parseInt(ID);
			this.name = name;
			this.SocS = SocS;
			this.hours = Double.valueOf(hours).doubleValue();
			this.rate = Double.valueOf(rate).doubleValue();
		}  // try
		catch (NumberFormatException err) {
			System.out.println("Invalid Format" + err);
			this.name = "";
			this.hours = 0.0;
			this.rate = 0.0;
		} // catch
	} // EmpInfo constructor

	double calc_fed_tax(double hours, double rate) {

		double yearly_income;

		yearly_income = hours * rate * 52;

		if (yearly_income < 30000.00)
			return (hours * rate * .28);

		else if (yearly_income < 50000.00)
			return (hours * rate * .32);

		else
			return (hours * rate * .38);

	}// calc_fed_tax

	double calc_gross_pay() {

		return (hours * rate * 10000000);

	}// calc_gross_pay

	double calc_state_tax(double hours, double rate) {
		return (hours * rate * .0561);

	}// calc_state_tax

	public String toString() {
		return (String.format("\n\n\t Employee Name:  %-25s", name)
				+ String.format("\n\t Soscial S. # :  %-25s", SocS)
				+ "\n\t Work Hours   :  "
				+ hours
				+ "\n\t Work Payrate :  "
				+ rate
				+ String.format("\n\t Gross Pay    :  %-26.2f",
						calc_gross_pay()) + String.format(
				"\n\t State Tax    :  %-26.2f", calc_state_tax(hours, rate)));
	}// toString

}// EmpInfo

public class ReadPayrollFileEucimar extends Frame implements ActionListener {

	EmpInfo Employee;

	private TextField RecID_F, Name_F, SocS_F, Hours_F, Rate_F;

	private Button enter, done;

	private DataInputStream input;

	public ReadPayrollFileEucimar() {
		super("Press READ to read the data");

		try {
			input = new DataInputStream(new FileInputStream("payroll.dat"));
		} // try
		catch (IOException e) {
			System.err.println("File not opened properly\n" + e.toString());
			System.exit(1);
		} // catch

		setSize(400, 300);
		setResizable(false);
		setLayout(new GridLayout(6, 2));

		add(new Label("Employee ID:"));
		RecID_F = new TextField();
		RecID_F.setEditable(false);
		add(RecID_F);

		add(new Label("Name:"));
		Name_F = new TextField();
		Name_F.setEditable(false);
		add(Name_F);

		add(new Label("Social Security #:"));
		SocS_F = new TextField();
		SocS_F.setEditable(false);
		add(SocS_F);

		add(new Label("Hours:"));
		Hours_F = new TextField();
		Hours_F.setEditable(false);
		add(Hours_F);

		add(new Label("Rate:"));
		Rate_F = new TextField();
		Rate_F.setEditable(false);
		add(Rate_F);

		enter = new Button("READ");
		enter.addActionListener(this);
		enter.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					inSource();
			} // keyPressed
		}/*KeyAdapter*/ );
		add(enter);

		done = new Button("DONE");
		done.addActionListener(this);
		done.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					closeFile();
			} // keyPressed
		}/*KeyAdapter*/ );
		add(done);

		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			} // windowClosing
		}/*WindowAdapter*/ );
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enter)
			inSource();
		else
			closeFile();
	} // actionPerformed

	public void inSource() {
		int ID;
		String name, socs;
		Double h, r;

		try {
			ID = input.readInt();
			name = input.readUTF();
			socs = input.readUTF();
			h = input.readDouble();
			r = input.readDouble();
			Employee = new EmpInfo(name, socs, h, r);

			System.out.println(Employee);

			RecID_F.setText(String.valueOf(ID));
			Name_F.setText(name);
			SocS_F.setText(socs);
			Hours_F.setText(String.valueOf(h));
			Rate_F.setText(String.valueOf(r));

		} // try
		catch (IOException err) {
			System.err.println("\nError During reading FILE!\n"
					+ err.toString());
			System.exit(1);
		} // catch
	} // inSource

	private void closeFile() {
		try {
			input.close();
			System.exit(0);
		} // try
		catch (IOException e) {
			System.err.println("\nClosing File Error!\n" + e.toString());
			System.exit(1);
		} // catch
	} // closeFile

	public static void main(String args[]) {
		new ReadPayrollFileEucimar();
	} // main
} // ReadPayrollFileEucimar
