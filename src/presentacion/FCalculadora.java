package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import logica.Calculadora;

public class FCalculadora extends JFrame implements ActionListener {
	private Calculadora calculadora;
	private boolean operador;
	private JLabel lResultado;
	private JButton jBotones[][] = new JButton[4][4];
	private String matriz[][] = {
			{"7", "8", "9", "/"},
			{"4", "5", "6", "*"},
			{"1", "2", "3", "-"},
			{"C", "0", "=", "+"}
	};

	public FCalculadora() {
		this.calculadora = new Calculadora();
		this.operador = false;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Parcial Calculadora");
		this.setSize(300, 400);
		this.setLayout(new BorderLayout());
		this.lResultado = new JLabel("0", SwingConstants.RIGHT);
		this.lResultado.setFont(new Font("", Font.BOLD, 70));
		this.add(this.lResultado, BorderLayout.NORTH);
		JPanel pBotones = new JPanel();
		pBotones.setLayout(new GridLayout(4, 4, 10, 10));
		this.add(pBotones, BorderLayout.CENTER);

		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				this.jBotones[i][j] = new JButton(this.matriz[i][j]);
				pBotones.add(this.jBotones[i][j]);
				this.jBotones[i][j].addActionListener(this);
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botonOprimido = (JButton)e.getSource();		
		if(botonOprimido.getText().equals(Calculadora.IGU)) {
			this.lResultado.setText(String.valueOf(this.calculadora.calcular()));
		}else if(botonOprimido.getText().equals(Calculadora.BOR)) {
			this.calculadora.setOp1(0);
			this.calculadora.setOp2(0);
			this.lResultado.setText("0");
		}else if(botonOprimido.getText().equals(Calculadora.SUM) ||
				botonOprimido.getText().equals(Calculadora.RES) ||
				botonOprimido.getText().equals(Calculadora.MUL) ||
				botonOprimido.getText().equals(Calculadora.DIV) ) {
			this.calculadora.setOp(botonOprimido.getText());
			this.operador = true;
		}else {
			if(this.operador) {
				this.lResultado.setText("0");
				this.operador = false;
			}
			this.lResultado.setText(String.valueOf(Integer.parseInt(this.lResultado.getText())*10 + Integer.parseInt(botonOprimido.getText())));
			if(this.calculadora.getOp() == "") {
				this.calculadora.setOp1(Integer.parseInt(this.lResultado.getText()));	
			}else {
				this.calculadora.setOp2(Integer.parseInt(this.lResultado.getText()));
			}

		}

	}

	public static void main(String[] args) {
		FCalculadora fPrincipal = new FCalculadora();
		fPrincipal.setVisible(true);
	}
}
