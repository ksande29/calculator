package calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class gui extends JFrame 
{
	private JPanel contentPane;
	private JTextField textField_display;
	private JPanel pnl_functions;
	private JButton btn_plus;
	private JButton btn_minus;
	private JButton btn_times;
	private JButton btn_divide;
	private JPanel panel_clear_numButton;
	private JButton btn_clear;
	private JPanel pnl_numberBtn;
	private JButton btn_7;
	private JButton btn_8;
	private JButton btn_9;
	private JButton btn_4;
	private JButton btn_5;
	private JButton btn_6;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_0;
	private JButton btn_decimal;
	private JButton btnx;
	private JButton btn_equal;
	private JPanel pnl_clear;
	
	private double currentValue = 0;
	private String mathString = "0";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gui() 
	{
		setUpMainWindow();
		makeResultDisplay();	
		makeFunctionsPanel();
		makeClearAndNumberPanels();
	}

	private void setUpMainWindow() 
	{
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 442);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private void makeResultDisplay() 
	{
		JPanel pnl_display = new JPanel();
		pnl_display.setBackground(Color.GRAY);
		pnl_display.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(pnl_display, BorderLayout.NORTH);
		pnl_display.setLayout(new GridLayout(0, 1, 0, 0));
		
		textField_display = new JTextField();
		textField_display.setPreferredSize(new Dimension(6, 50));
		textField_display.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_display.setBackground(new Color(255, 255, 255));
		textField_display.setEditable(false);
		textField_display.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_display.setText(mathString);
		pnl_display.add(textField_display);
		textField_display.setColumns(10);
	}

	private void makeFunctionsPanel() 
	{
		pnl_functions = new JPanel();
		pnl_functions.setBackground(Color.GRAY);
		pnl_functions.setBorder(new EmptyBorder(10, 0, 10, 10));
		contentPane.add(pnl_functions, BorderLayout.EAST);
		pnl_functions.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn_plus = makeBtn("+", pnl_functions, Color.DARK_GRAY, Color.WHITE);
		btn_plus.setFont(new Font("Tahoma", Font.PLAIN, 30));	
		btn_minus = makeBtn("-", pnl_functions, Color.DARK_GRAY, Color.WHITE);
		btn_minus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_times = makeBtn("*", pnl_functions, Color.DARK_GRAY, Color.WHITE);
		btn_times.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_divide = makeBtn("/", pnl_functions, Color.DARK_GRAY, Color.WHITE);
		btn_divide.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_equal = makeBtn("=", pnl_functions, new Color(25,25,112), Color.WHITE);
		btn_equal.setFont(new Font("Tahoma", Font.PLAIN, 30));
	}

	
	private void makeClearAndNumberPanels() 
	{
		panel_clear_numButton = new JPanel();
		panel_clear_numButton.setBackground(Color.GRAY);
		panel_clear_numButton.setBorder(new EmptyBorder(0, 10, 10, 10));
		contentPane.add(panel_clear_numButton, BorderLayout.CENTER);
		panel_clear_numButton.setLayout(new BorderLayout(0, 0));
		
		makeClearPanel();	
		makeNumberPanel();
	}

	private void makeClearPanel() 
	{
		pnl_clear = new JPanel();
		pnl_clear.setBackground(Color.GRAY);
		pnl_clear.setBorder(null);
		FlowLayout fl_pnl_clear = (FlowLayout) pnl_clear.getLayout();
		fl_pnl_clear.setAlignment(FlowLayout.LEFT);
		panel_clear_numButton.add(pnl_clear, BorderLayout.NORTH);
		
		btn_clear = makeBtn("Clear", pnl_clear, new Color(128, 0, 0), Color.WHITE);
		btn_clear.setFont(new Font("Tahoma", Font.PLAIN, 20));
	}
	
	private void makeNumberPanel() 
	{
		pnl_numberBtn = new JPanel();
		pnl_numberBtn.setBackground(Color.GRAY);
		pnl_numberBtn.setBorder(new EmptyBorder(10, 0, 0, 0));
		panel_clear_numButton.add(pnl_numberBtn, BorderLayout.CENTER);
		pnl_numberBtn.setLayout(new GridLayout(0, 3, 0, 0));
		
		//make number buttons
		btn_7 = makeBtn("7", pnl_numberBtn, Color.WHITE, Color.BLACK);
		btn_8 = makeBtn("8", pnl_numberBtn, Color.WHITE, Color.BLACK);
		btn_9 = makeBtn("9", pnl_numberBtn, Color.WHITE, Color.BLACK);	
		btn_4 = makeBtn("4", pnl_numberBtn, Color.WHITE, Color.BLACK);
		btn_5 = makeBtn("5", pnl_numberBtn, Color.WHITE, Color.BLACK);
		btn_6 = makeBtn("6", pnl_numberBtn, Color.WHITE, Color.BLACK);
		btn_1 = makeBtn("1", pnl_numberBtn, Color.WHITE, Color.BLACK);
		btn_2 = makeBtn("2", pnl_numberBtn, Color.WHITE, Color.BLACK);	
		btn_3 = makeBtn("3", pnl_numberBtn, Color.WHITE, Color.BLACK);
		btn_0 = makeBtn("0", pnl_numberBtn, Color.WHITE, Color.BLACK);
		btn_decimal = makeBtn(".", pnl_numberBtn, Color.WHITE, Color.BLACK);		
		btnx = makeBtn("1/x", pnl_numberBtn, Color.DARK_GRAY, Color.WHITE);
	}

	

	
	private JButton makeBtn(String key, JPanel panel, Color bgColor, Color txtColor) 
	{
		JButton btn = new JButton(key);
		btn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				if (key.equals("Clear"))
				{
					currentValue = 0;
					mathString = "0";
				}
				else if (key.equals("="))
				{			
					System.out.println(mathString);
					try 
				    {
						Expression ex = new ExpressionBuilder(mathString).build();
						currentValue = ex.evaluate();
				    	mathString = "";
				    	
				    	if (currentValue == 0)
				    		mathString += "0";
				    	else
				    		mathString += currentValue;
				    } catch (Exception e1) 
				    {
				    	mathString = "ERROR"; 
				    	System.out.println("error");
				    }
				}
				else if (key.equals("."))
				{
					mathString += ".";
				}
				else if (key.equals("1/x"))
				{
					//evaluate expression
					Expression ex = new ExpressionBuilder(mathString).build();
					currentValue = ex.evaluate();	
					//take inverse of expression
					currentValue = 1 / currentValue;
					mathString = "" + currentValue;
				}
				else
				{
					if (mathString.equals("0"))
						mathString = key;
					else
						mathString += key;
				}
				textField_display.setText(mathString);
			}
		});
		btn.setBackground(bgColor);
		btn.setForeground(txtColor);
		panel.add(btn);
		
		return btn;
	}

}
