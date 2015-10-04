package IHM;

import javax.swing.JFrame;
import Maps.Mapper;

public class Display extends JFrame{
	private static final long serialVersionUID = 649615923424177620L;
	public Display(){
		setTitle("Pharaos"); //On donne un titre a l'application
		setSize(600,600); //On donne une taille a notre fenetre
		setLocationRelativeTo(null); //On centre la fenetre sur l'ecran
		setResizable(false); //On interdit le redimensionnement de la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit a l'application de se fermer lors du clic
		Mapper maps = new Mapper();
		getContentPane().add(maps);
		Menu menu = new Menu(maps);
		getContentPane().add(menu);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String[] args) throws InterruptedException {
				new Display();
	}
}
