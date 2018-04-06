import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MaxNumberSWT {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell();
		shell.setText("Максимальное число");
		MaxNumberModel theModel = new MaxNumberModel();	
		MaxNumberVC maxNumberVC = new MaxNumberVC(display, shell, theModel);		
		
		shell.open();
		while (!shell.isDisposed() ) {
			if (!display.readAndDispatch() ) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
