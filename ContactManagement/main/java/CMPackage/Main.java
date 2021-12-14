package CMPackage;

public class Main 
{
	static FrameMenu fmenu = new FrameMenu();
	static FrameAdd fadd = new FrameAdd();
	static FrameDisplay fdis = new FrameDisplay();
	static FrameDelete fdel = new FrameDelete();
	static ContactManager contactManager = new ContactManager();
	
	public static void main(String args[])
	{
		fmenu.setVisible(true);
	}
}
 