package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;

public class VentanaLocalidad extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controlador controlador;

	public VentanaLocalidad(Controlador controlador)
	{
		super();
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 327, 164);
		contentPane.add(panel);
		panel.setLayout(null);

		this.setVisible(true);
	}

}
