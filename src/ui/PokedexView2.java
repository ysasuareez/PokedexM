package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import utils.Almacen;
import java.awt.Font;
import ui.LoginView;
import ui.CrearView;
import java.awt.Color;
import java.awt.Panel;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

import dao.PokemonDAO;
import enums.TiposPokemon;
import models.Pokemon;

import javax.swing.border.EtchedBorder;

public class PokedexView2 {

	private int idPokemon;
	private JFrame framePokedexView;
	private JFrame frameLoginView;
	private JLabel lblTipo1;
	private JTextField lblTipoPoke1;
	private JButton btnMenos;
	private JButton btnMas;
	private JFrame parent;
	private JLabel lblAltura;
	private JTextField lblAlturaPoke;
	private JLabel lblPeso;
	private JTextField lblPesoPoke;
	private JLabel lblNombrePoke;
	private JLabel lblCategoria;
	private JTextField lblCategoriaPoke;
	private JLabel lblHabilidad;
	private JTextField lblHabilidadPoke;
	private JButton btnActualizar;
	private JButton btnBorrar;
	private JButton btnCrear;
	private JButton btnCerrarSesion;
	private String username;
	private JLabel lblNumeroPokemon;
	private JLabel lblTipo2;
	private JTextField lblTipoPoke2;
	private Panel bordePantalla;
	private JPanel Pantalla;
	private JPanel bordeCrear;
	private JPanel bordeActualizar;
	private JPanel bordeBorrar;
	private JPanel bordeSalir;
	private Panel fondoBienvebido;
	private JLabel lblBienvenido;
	private JPanel vertical;
	private JPanel horizontal;
	private Panel deco1;
	private Panel deco2;
	private Panel decoIzq;
	private Panel rejilla1;
	private Panel rejilla1_1;
	private Panel rejilla1_2;
	private Panel rejilla1_3;
	private JLabel lblImagen;
	private JLabel lblBienvenido_1;
	private PokemonDAO pokemonDAO;
	private ArrayList <Pokemon> lista_pokemons;
	private int indice;



	/**
	 * Create the application. (Constructor)
	 */	
	public PokedexView2(JFrame parent, String username) {
		initialize();
		this.username = username;
		this.parent = parent;
		this.pokemonDAO = new PokemonDAO();		
		this.lista_pokemons = pokemonDAO.getAll();
		indice = 0;
		if (this.lista_pokemons.size() > 0) {
			printPokemon();
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureUIComponents();
		configureListeners();
	}
	

	/**
	 * Componentes View 
	 */
	private void configureUIComponents() {
		framePokedexView = new JFrame();
		framePokedexView.getContentPane().setBackground(Color.RED);
		framePokedexView.getContentPane();
		framePokedexView.getContentPane().setLayout(null);
		framePokedexView.setVisible(true);
		
		//TITULO
		framePokedexView.setTitle ("POKEDEX");
		framePokedexView.setBounds(100, 100, 500, 641);
		framePokedexView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//BORDE GRIS
		bordePantalla = new Panel();
		bordePantalla.setBackground(SystemColor.activeCaptionBorder);
		bordePantalla.setBounds(45, 30, 400, 386);
		framePokedexView.getContentPane().add(bordePantalla);
		bordePantalla.setLayout(null);
		
				//DECORACIÓN BORDE GRIS
				decoIzq = new Panel();
				decoIzq.setBackground(Color.RED);
				decoIzq.setBounds(37, 355, 22, 22);
				bordePantalla.add(decoIzq);
				
				deco1 = new Panel();
				deco1.setBackground(Color.RED);
				deco1.setBounds(183, 12, 10, 10);
				bordePantalla.add(deco1);
				
				deco2 = new Panel();
				deco2.setBackground(Color.RED);
				deco2.setBounds(213, 12, 10, 10);
				bordePantalla.add(deco2);
				
				rejilla1 = new Panel();
				rejilla1.setBounds(334, 374, 30, 3);
				bordePantalla.add(rejilla1);
				rejilla1.setBackground(Color.BLACK);
				
				rejilla1_1 = new Panel();
				rejilla1_1.setBounds(334, 367, 30, 3);
				bordePantalla.add(rejilla1_1);
				rejilla1_1.setBackground(Color.BLACK);
				
				rejilla1_2 = new Panel();
				rejilla1_2.setBounds(334, 360, 30, 3);
				bordePantalla.add(rejilla1_2);
				rejilla1_2.setBackground(Color.BLACK);
				
				rejilla1_3 = new Panel();
				rejilla1_3.setBounds(334, 353, 30, 3);
				bordePantalla.add(rejilla1_3);
				rejilla1_3.setBackground(Color.BLACK);
		
		
		//PANTALLA
		Pantalla = new JPanel();
		Pantalla.setLayout(null);
		Pantalla.setForeground(Color.BLACK);
		Pantalla.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		Pantalla.setBackground(Color.WHITE);
		Pantalla.setBounds(37, 31, 327, 317);
		bordePantalla.add(Pantalla);		
		
		
		//DENTRO DE PANTALLA
		
				//NÚMERO
				lblNumeroPokemon = new JLabel("POKEMON Nº " + (indice));
				lblNumeroPokemon.setFont(new Font("Caladea", Font.BOLD | Font.ITALIC, 17));
				lblNumeroPokemon.setBounds(20, 10, 156, 49);
				Pantalla.add(lblNumeroPokemon);
				
				//NOMBRE
				lblNombrePoke = new JLabel ();
				lblNombrePoke.setHorizontalAlignment(SwingConstants.CENTER);
				lblNombrePoke.setFont(new Font("Caladea", Font.BOLD, 20));
				lblNombrePoke.setBounds(145, 10, 172, 49);
				Pantalla.add(lblNombrePoke);
								
				//TIPOS
				lblTipo1 = new JLabel ("Tipo 1:");
				lblTipo1.setFont(new Font("Alef", Font.BOLD, 12));
				lblTipo1.setBounds(20, 236, 56, 13);
				Pantalla.add(lblTipo1);
				lblTipo1.setHorizontalAlignment(SwingConstants.LEFT);
				
				lblTipoPoke1 = new JTextField ();
				lblTipoPoke1.setBackground(Color.WHITE);
				lblTipoPoke1.setEditable(false);
				lblTipoPoke1.setFont(new Font("Alef", Font.PLAIN, 13));
				lblTipoPoke1.setBounds(73, 231, 66, 20);
				Pantalla.add(lblTipoPoke1);
				
				
				lblTipo2 = new JLabel("Tipo 2:");
				lblTipo2.setFont(new Font("Alef", Font.BOLD, 12));
				lblTipo2.setBounds(20, 259, 56, 13);
				Pantalla.add(lblTipo2);
				lblTipo2.setHorizontalAlignment(SwingConstants.LEFT);
				
				lblTipoPoke2 = new JTextField();
				lblTipoPoke2.setBackground(Color.WHITE);
				lblTipoPoke2.setEditable(false);
				lblTipoPoke2.setFont(new Font("Alef", Font.PLAIN, 13));
				lblTipoPoke2.setBounds(73, 254, 66, 20);
				Pantalla.add(lblTipoPoke2);
				
				//ALTURA
				lblAltura = new JLabel ("Altura:");
				lblAltura.setFont(new Font("Alef", Font.BOLD, 12));
				lblAltura.setBounds(20, 282, 56, 13);
				Pantalla.add(lblAltura);
				lblAltura.setHorizontalAlignment(SwingConstants.LEFT);
				
				lblAlturaPoke = new JTextField ();
				lblAlturaPoke.setBackground(Color.WHITE);
				lblAlturaPoke.setEditable(false);
				lblAlturaPoke.setFont(new Font("Alef", Font.PLAIN, 13));
				lblAlturaPoke.setBounds(73, 277, 71, 20);
				Pantalla.add(lblAlturaPoke);
				
				//PESO
				lblPeso = new JLabel ("Peso:");
				lblPeso.setFont(new Font("Alef", Font.BOLD, 12));
				lblPeso.setBounds(149, 236, 56, 13);
				Pantalla.add(lblPeso);
				lblPeso.setHorizontalAlignment(SwingConstants.LEFT);
				
				lblPesoPoke = new JTextField ();
				lblPesoPoke.setBackground(Color.WHITE);
				lblPesoPoke.setEditable(false);
				lblPesoPoke.setFont(new Font("Alef", Font.PLAIN, 13));
				lblPesoPoke.setBounds(223, 231, 71, 20);
				Pantalla.add(lblPesoPoke);
								
				//CATEGORIA
				lblCategoria = new JLabel ("Categoria:");
				lblCategoria.setFont(new Font("Alef", Font.BOLD, 12));
				lblCategoria.setBounds(149, 259, 66, 13);
				Pantalla.add(lblCategoria);
				lblCategoria.setHorizontalAlignment(SwingConstants.LEFT);
				
				lblCategoriaPoke = new JTextField ();
				lblCategoriaPoke.setBackground(Color.WHITE);
				lblCategoriaPoke.setEditable(false);
				lblCategoriaPoke.setFont(new Font("Alef", Font.PLAIN, 13));
				lblCategoriaPoke.setBounds(223, 254, 71, 20);
				Pantalla.add(lblCategoriaPoke);
				
				//HABILIDAD
				lblHabilidad = new JLabel ("Habilidad:");
				lblHabilidad.setFont(new Font("Alef", Font.BOLD, 12));
				lblHabilidad.setBounds(149, 282, 56, 13);
				Pantalla.add(lblHabilidad);
				lblHabilidad.setHorizontalAlignment(SwingConstants.LEFT);
				
				lblHabilidadPoke = new JTextField ();
				lblHabilidadPoke.setBackground(Color.WHITE);
				lblHabilidadPoke.setEditable(false);
				lblHabilidadPoke.setFont(new Font("Alef", Font.PLAIN, 13));
				lblHabilidadPoke.setBounds(223, 277, 78, 20);
				Pantalla.add(lblHabilidadPoke);																
				
				
				//IMAGEN
				lblImagen = new JLabel();
				lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
				lblImagen.setIcon(new ImageIcon(""));
				lblImagen.setBounds(20, 51, 275, 153);
				Pantalla.add(lblImagen);
				
				
								

				
		//BOTÓN CREAR
		bordeCrear = new JPanel();
		bordeCrear.setLayout(null);
		bordeCrear.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		bordeCrear.setBackground(new Color(0, 153, 255));
		bordeCrear.setBounds(45, 448, 109, 23);
		framePokedexView.getContentPane().add(bordeCrear);				
		
		btnCrear = new JButton("CREAR");
		btnCrear.setBounds(-14, -13, 137, 49);
		bordeCrear.add(btnCrear);
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setFont(new Font("Alef", Font.BOLD, 14));
		btnCrear.setBackground(new Color(102, 153, 204));
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		//BOTON ACTUALIZAR
		bordeActualizar = new JPanel();
		bordeActualizar.setLayout(null);
		bordeActualizar.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		bordeActualizar.setBackground(new Color(204, 0, 0));
		bordeActualizar.setBounds(188, 448, 107, 23);
		framePokedexView.getContentPane().add(bordeActualizar);			
		
		btnActualizar = new JButton ("ACTUALIZAR");
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setFont(new Font("Alef", Font.BOLD, 14));
		btnActualizar.setBackground(new Color(51, 51, 51));
		btnActualizar.setBounds(-14, -13, 137, 49);
		bordeActualizar.add(btnActualizar);
		
		
		//BOTON BORRAR 
		bordeBorrar = new JPanel();
		bordeBorrar.setLayout(null);
		bordeBorrar.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		bordeBorrar.setBackground(new Color(204, 0, 0));
		bordeBorrar.setBounds(47, 488, 107, 23);
		framePokedexView.getContentPane().add(bordeBorrar);
				
		btnBorrar = new JButton ("BORRAR");
		btnBorrar.setBackground(new Color(51, 51, 51));
		btnBorrar.setFont(new Font("Alef", Font.BOLD, 14));
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setBounds(-14, -13, 137, 49);
		bordeBorrar.add(btnBorrar);
		
		//BOTÓN SALIR (AL LOGIN VIEW)
		bordeSalir = new JPanel();
		bordeSalir.setLayout(null);
		bordeSalir.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		bordeSalir.setBackground(new Color(0, 153, 255));
		bordeSalir.setBounds(188, 488, 109, 23);
		framePokedexView.getContentPane().add(bordeSalir);
				
		btnCerrarSesion = new JButton("SALIR");
		btnCerrarSesion.setBackground(new Color(102, 153, 204));
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setBounds(-14, -13, 137, 49);
		bordeSalir.add(btnCerrarSesion);
		
		//PANEL VERDE Y SU MENSAJE AL USER
		fondoBienvebido = new Panel();
		fondoBienvebido.setLayout(null);
		fondoBienvebido.setBackground(new Color(0, 204, 102));
		fondoBienvebido.setBounds(45, 528, 250, 40);
		framePokedexView.getContentPane().add(fondoBienvebido);
		
		lblBienvenido = new JLabel("Entrenador Pokemon ");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblBienvenido.setBounds(0, 2, 250, 18);
		fondoBienvebido.add(lblBienvenido);
		
		lblBienvenido_1 = new JLabel(username);
		lblBienvenido_1.setBounds(0, 18, 250, 20);
		fondoBienvebido.add(lblBienvenido_1);
		lblBienvenido_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido_1.setForeground(Color.WHITE);
		lblBienvenido_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		
		
		//DECORACIÓN DIRECCIONES 
		vertical = new JPanel();
		vertical.setLayout(null);
		vertical.setBackground(Color.BLACK);
		vertical.setBounds(365, 448, 40, 120);
		framePokedexView.getContentPane().add(vertical);
				
		horizontal = new JPanel();
		horizontal.setLayout(null);
		horizontal.setBackground(Color.BLACK);
		horizontal.setBounds(325, 488, 120, 40);
		framePokedexView.getContentPane().add(horizontal);			
			
				//BOTON SIGUIENTE
				btnMas = new JButton(">");
				btnMas.setForeground(new Color(153, 153, 153));
				btnMas.setBackground(new Color(0, 0, 0));
				btnMas.setBounds(77, -2, 45, 45);
				horizontal.add(btnMas);
				btnMas.setFont(new Font("Tahoma", Font.PLAIN, 13));
				
				//BOTON ANTERIOR
				btnMenos = new JButton("<");
				btnMenos.setForeground(new Color(153, 153, 153));
				btnMenos.setBackground(new Color(0, 0, 0));
				btnMenos.setBounds(-2, -2, 45, 45);
				horizontal.add(btnMenos);
				btnMenos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		


	}
	
	/**
	 * MÉTODOS de cada botón
	 */
	private void configureListeners() {

		//Si presionas Cerrar Sesión se eliminará la ventana de pokedex y volverá a aprecer parent (en este caso es la LoginView)
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePokedexView.dispose();
				parent.setVisible(true);
			}
		});
		
		//Borra el pokemon en el que te encuentras, al menos debes tener 1
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Almacen.lista_pokemons.size() > 1) {
					Almacen.lista_pokemons.remove(idPokemon);
					new PokedexView();
					framePokedexView.dispose();
				} else {
					JOptionPane.showMessageDialog(btnBorrar, "Debes tener al menos un pokemon registrado.");
				}
			}
		});
		
		//Actualiza los datos del pokemon en el que te encuentras
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ActualizarView(framePokedexView, indice, lista_pokemons.get(indice));
				framePokedexView.dispose();
			}
		});
		
		//Va hacia atrás en la lista de pokemons, no podrás retroceder más de lo que tienes
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indice--;
				
				if(indice == lista_pokemons.size()) {
					indice = 0;
				}
				
				printPokemon();		

			}
		});
		
		//Va hacia delante en la lista de pokemons, no podrás avanzar más de lo que tienes
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indice++;
				
				if(indice == lista_pokemons.size()) {
					indice = 0;
				}
				
				printPokemon();	
					
					
								
			}
		});
		
		//Cambia al CreacionView
		btnCrear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			framePokedexView.dispose();
			new CrearView(lista_pokemons.size()+1);
		}
		});
		
}

	
	public void printPokemon() {
		
		if (lista_pokemons.size() > 0) {
			Pokemon pokemon = lista_pokemons.get(indice);
			lblNombrePoke.setText(pokemon.getNombre());
			lblTipoPoke1.setText(String.valueOf(pokemon.getTipo1()));
			lblTipoPoke2.setText(String.valueOf(pokemon.getTipo2()));
			lblAlturaPoke.setText(String.valueOf(pokemon.getAltura()));
			lblPesoPoke.setText(String.valueOf(pokemon.getPeso()));
			lblCategoriaPoke.setText(pokemon.getCategoria());
			lblHabilidadPoke.setText(pokemon.getHabilidad());
			lblImagen.setText(pokemon.getImagen());
		}
		
	}
}
