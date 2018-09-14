import javax.swing.JFrame;

public class Frame extends JFrame {

	public Frame() {
		super();
		initialize();
	}
	
	private void initialize() {
		this.setTitle("PCDenda");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600,475);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
}
