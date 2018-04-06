import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class MaxNumberVC{
	private MaxNumberModel theModel;
	private Display display;
	private Shell shell;
	
	private GridLayout gridLayout;
	private GridData gridData;
	private Button findMaxNumberButton;
	
	private Label number1Lbl;
	private Text number1Txt;
	private Label number2Lbl;	
	private Text number2Txt;
	private Label number3Lbl;
	private Text number3Txt;
	private Label maxLbl;
	
	MaxNumberVC(Display display, Shell shell, MaxNumberModel theModel){	
		this.theModel = theModel;
		this.display = display;
		this.shell = shell;
		gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		gridLayout.marginLeft = 10;
		gridLayout.marginRight = 10;
		gridLayout.marginHeight = 10;
		gridLayout.marginWidth = 10;
		gridLayout.verticalSpacing = 10;
		gridLayout.horizontalSpacing = 10;
		shell.setLayout(gridLayout);
		shell.setSize(350,200);
		
		//First horizontal string
		number1Lbl = new Label(shell, SWT.HORIZONTAL);
		number1Lbl.setText("Число 1:");
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 3;
		number1Txt = new Text(shell, SWT.SINGLE);
		number1Txt.setLayoutData(gridData);
		
		//Second horizontal string
		number2Lbl = new Label(shell, SWT.HORIZONTAL);
		number2Lbl.setText("Число 2:");
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 3;
		number2Txt = new Text(shell, SWT.SINGLE);
		number2Txt.setLayoutData(gridData);
		
		//Third horizontal string
		number3Lbl = new Label(shell, SWT.HORIZONTAL);
		number3Lbl.setText("Число 3:");
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 3;
		number3Txt = new Text(shell, SWT.SINGLE);
		number3Txt.setLayoutData(gridData);
		
		//Forth horizontal string
		maxLbl = new Label(shell, SWT.HORIZONTAL);
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 3;
		//gridData.horizontalIndent = 10;

		gridData.grabExcessHorizontalSpace = true;
		//gridData.minimumWidth = 1;
		maxLbl.setLayoutData(gridData);
		maxLbl.setText("Максимальное ");
		
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		findMaxNumberButton = new Button(shell, SWT.PUSH | SWT.RIGHT);
		findMaxNumberButton.setLayoutData(gridData);
		findMaxNumberButton.setText("Посчитать  ");
		
	
		findMaxNumberButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				int firstNumber, secondNumber, thirdNumber = 0;
				 try{						 
					 firstNumber = getFirstNumber();
					 secondNumber = getSecondNumber();
				     thirdNumber = getThirdNumber();
				     theModel.findMaxNumber(firstNumber, secondNumber, thirdNumber);
				     setMaxNumber(theModel.getMaxNumber());				     
				 }
				 catch(NumberFormatException ex){					 
					 System.out.println(ex);
					 displayErrorMessage("Необходимо ввести 3 целых числа.");	
				 }				
			}
		});
		
	}
	
	public int getFirstNumber() {
		return Integer.parseInt(number1Txt.getText());
	}
	
	public int getSecondNumber() {
		return Integer.parseInt(number2Txt.getText());
	}
	
	public int getThirdNumber() {
		return Integer.parseInt(number3Txt.getText());
	}
	
	public void setMaxNumber(int maxNumber) {
		maxLbl.setText("Максимальное " + Integer.toString(maxNumber));
	}
	
	void displayErrorMessage(String errorMessage) {
		MessageBox messageBox = new MessageBox(this.shell, SWT.ICON_WARNING);
		messageBox.setText("Внимание!");
		messageBox.setMessage(errorMessage);	 
		messageBox.open();
	
	}
	
}
