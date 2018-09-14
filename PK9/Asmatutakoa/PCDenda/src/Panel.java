import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Panel extends JPanel implements ActionListener{
	
	private Image background;
	private Image barra;
	
	private Informatikaria informatikaria;
	private Pertsona[] pertsonak;

	private SpriteSheet people;
	private SpriteSheet pcColors;
	private BufferedImage geldikDown;
	private BufferedImage geldikUp;
	private Image konpontzenGif;
	private Image zzzGif;
	public int nextComputer;
	
	public int pertsonaKopurua = 0;
	public int atendituta = 0;
	public int ordenadoreakKonpontzeko = 0;
	public int ordenadoreakEginak = 0;
	public boolean eskatzen = false;
	public boolean kanpoan = false;
	public boolean begiratzen = false;
	
	private Animation oinezUp;
	private Animation oinezDown;
	private Animation oinezLeft;
	private Animation oinezRight;
	
	// Ordenagailuak
	public int[] ordenagailuak = new int[PCDendaApp.ORDENAGAILU_MAX];
	public int[] ordenagailuKonponduak = new int[PCDendaApp.ORDENAGAILU_MAX];	
	
	// Posizioak
	public int[] posizioak = new int[PCDendaApp.PERTSONA_KOPURUA];
	
	public int hartzeko = 0;
	
	
	public Panel(Informatikaria informatikaria, Pertsona[] pertsonak) {
		for (int i=0; i < ordenagailuak.length; i++) {
			ordenagailuak[i] = 0;
		}
		for (int i=0; i < ordenagailuKonponduak.length; i++) {
			ordenagailuKonponduak[i] = 0;
		}
		for (int i=0; i < posizioak.length; i++) {
			posizioak[i] = 0;
		}
		this.informatikaria = informatikaria;
		this.pertsonak = pertsonak;
		
		this.setBackground(Color.BLACK);
		ImageIcon backgroundII = new ImageIcon(this.getClass().getResource("store.png"));
		background = backgroundII.getImage();
		ImageIcon barraII = new ImageIcon(this.getClass().getResource("storeBarra.png"));
		barra = barraII.getImage();
		ImageIcon konpontzenII = new ImageIcon(this.getClass().getResource("Fightcloud.gif"));
		konpontzenGif = konpontzenII.getImage();
		ImageIcon zzzII = new ImageIcon(this.getClass().getResource("zzz.gif"));
		zzzGif = zzzII.getImage();
		
		people = new SpriteSheet("people.png");
		pcColors = new SpriteSheet("pcColors.png");
		
		loadSpritesAndAnimations();
		
		Timer timer = new Timer(15, this);
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(background, 0, 0, this);
		
		printOrdenagailuak(g);
		
		printInformatikaria(g);
		
		// Barra
		g.drawImage(barra, 0, 0, this);
		
		if(hartzeko > 0) {
			BufferedImage pc = pcColors.grabImage(hartzeko, 1, 32, 32);
			g.drawImage(pc, informatikaria.x, informatikaria.y+16,this);
		}
		
		printOrdenagailuKonponduak(g);
		
		printPertsonak(g);
		
		printDatuak(g);
	}

	private void printDatuak(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Courier New", Font.BOLD, 48));
		g.drawString("PRK", 300, 50);
		g.drawString("PCDenda", 300, 100);
		
		g.setFont(new Font("Courier New", Font.BOLD, 18));
		g.drawString("Datuak", 300, 220);
		g.drawLine(295, 223, 600, 223);
		g.drawLine(295, 224, 600, 224);
		g.drawLine(295, 225, 600, 225);
		
		g.setFont(new Font("Courier New", Font.BOLD, 14));
		
		g.drawString("Pertsona Kopurua: " + pertsonaKopurua, 300, 250);
		g.drawString("Pertsona Atendituta: " + atendituta, 300, 265);
		g.drawString("Ordenadoreak Konpontzeko: " + ordenadoreakKonpontzeko, 300, 280);
		g.drawString("Ordenadoreak Konponduta: " + ordenadoreakEginak, 300, 295);
		g.drawString("Pertsona Eskatzen: " + (eskatzen? "Bai" : "Ez"), 300, 325);
		g.drawString("Informatikaria Kanpoan: " + (kanpoan? "Bai" : "Ez"), 300, 340);
		g.drawString("Pertsona Begiratzen: " + (begiratzen? "Bai" : "Ez"), 300, 355);
		
		if(informatikaria.konpontzen) {
			g.setColor(Color.RED);
			g.setFont(new Font("Courier New", Font.BOLD, 22));
			g.drawString("Konpontzen...", 350, 420);
		}
	}

	private void printPertsonak(Graphics g) {
		for(Pertsona i: pertsonak) {							
			if(!i.emanda) {
				BufferedImage pc = pcColors.grabImage(i.id, 1, 32, 32);
				g.drawImage(pc, i.x, i.y-32,this);
			}
			if(i.geldik) {
				g.drawImage(geldikUp, i.x, i.y, this);
			} else {
				switch(i.move) {
				case 0:
					oinezUp.drawAnimation(g, i.x, i.y, 0);
					break;
				case 1:
					oinezRight.drawAnimation(g, i.x, i.y, 0);
					break;
				case 2:
					oinezDown.drawAnimation(g, i.x, i.y, 0);
					break;
				case 3:
					oinezLeft.drawAnimation(g, i.x, i.y, 0);
					break;
				}
				
			}			
			g.setColor(Color.WHITE);
			g.drawString(""+i.id, i.x+11, i.y+18);
		}
	}

	private void printOrdenagailuak(Graphics g) {
		for(int i = 0; i < ordenagailuak.length; i++) {
			if (ordenagailuak[i] > 0) {
				BufferedImage pcColor = pcColors.grabImage(ordenagailuak[i], 1, 32, 32);
				g.drawImage(pcColor, 96+i*32, 0, this);	
			}
		}
	}

	private void printOrdenagailuKonponduak(Graphics g) {
		for(int i = 0; i < ordenagailuKonponduak.length; i++) {
			if (ordenagailuKonponduak[i] > 0) {
				BufferedImage pcColor = pcColors.grabImage(ordenagailuKonponduak[i], 1, 32, 32);
				g.drawImage(pcColor, 96-i*32, 256, this);	
			}
		}
	}

	private void printInformatikaria(Graphics g) {
		int x = informatikaria.x;
		int y = informatikaria.y;
		if(informatikaria.geldik) {			
			switch(informatikaria.move) {
			case 2:
				g.drawImage(geldikDown, x, y, this);
				break;
			case 0:
				g.drawImage(geldikUp, x, y, this);
				break;
			}
		} else {
			switch(informatikaria.move) {
			case 0:
				BufferedImage pc = pcColors.grabImage(nextComputer, 1, 32, 32);
				g.drawImage(pc, x, y-32,this);
				oinezUp.drawAnimation(g, x, y, 0);
				break;
			case 2:
				oinezDown.drawAnimation(g, x, y, 0);
				break;
			}
			
		}
		if(informatikaria.konpontzen) {
			g.drawImage(konpontzenGif, x-75, y-75, this);
		}
		if(informatikaria.izarreiBegira) {
			g.drawImage(zzzGif, x+30, y-100, this);
		}
	}
	
	private void loadSpritesAndAnimations() {
		geldikUp = people.grabImage(1, 1, 32, 32);
		geldikDown = people.grabImage(3, 2, 32, 32);
		BufferedImage oinezUp1 = people.grabImage(2, 4, 32, 32);
		BufferedImage oinezUp2 = people.grabImage(3, 1, 32, 32);
		oinezUp = new Animation(10, oinezUp1, oinezUp2);
		BufferedImage oinezDown1 = people.grabImage(3, 3, 32, 32);
		BufferedImage oinezDown2 = people.grabImage(3, 4, 32, 32);
		oinezDown = new Animation(10, oinezDown1, oinezDown2);
		BufferedImage oinezLeft1 = people.grabImage(1, 2, 32, 32);
		BufferedImage oinezLeft2 = people.grabImage(1, 4, 32, 32);
		oinezLeft = new Animation(10, oinezLeft1, oinezLeft2);
		BufferedImage oinezRight1 = people.grabImage(2, 2, 32, 32);
		BufferedImage oinezRight2 = people.grabImage(2, 3, 32, 32);
		oinezRight = new Animation(10, oinezRight1, oinezRight2);
		
	}

	public void actionPerformed(ActionEvent e) {
		oinezUp.runAnimation();
		oinezDown.runAnimation();
		oinezLeft.runAnimation();
		oinezRight.runAnimation();
		repaint();
	}
	
	public void updateData(int pertsonaKopurua, int atendituta, int ordenadoreakKonpontzeko, int ordenadoreakEginak, boolean eskatzen, boolean kanpoan, boolean begiratzen) {
		this.pertsonaKopurua = pertsonaKopurua;
		this.atendituta = atendituta;
		this.ordenadoreakKonpontzeko = ordenadoreakKonpontzeko;
		this.ordenadoreakEginak = ordenadoreakEginak;
		this.eskatzen = eskatzen;
		this.kanpoan = kanpoan;
		this.begiratzen = begiratzen;
	}
	
	

}
