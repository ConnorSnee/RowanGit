package registrar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.*;
import javax.swing.border.Border;

public class BannerUI extends JFrame {
	
	private static final int GUI_WIDTH = 1200;
	
	//Instance variables for model elements
	private Student student;
	private Term term;
	private ArrayList<Section> sections;
	
	//Instance variables for top panel
	private JComboBox<String> cmbDepartments;
	private JPanel pnlDepartment;
	
	//Instance variables for middle panel
	private JLabel lblCRN;
	private JLabel lblCourseNum;
	private JLabel lblTitle;
	private JLabel lblInstructor;
	private JLabel lblSchedule;
	private JPanel pnlSectionList;
	private JButton btnCRN;
	
	//Instance variables for bottom panel
	private JLabel lblFeedback = new JLabel("Matching Sections");
	private JPanel pnlFeedback;
	
	public BannerUI(Student student, Term term) {
		super("Banner Self Service for: " + student.getLastName());
		this.student = student;
		this.term = term;
		this.sections = term.getSections();
		this.setupFrame();
		this.addComponents();
		this.addListeners();
		setVisible(true);
	}
	
	private void addComponents() {
		
		JLabel lblDepartment = new JLabel("Select a department: ");
		
		// ******* First/Top - Department Panel ********
		pnlDepartment = new JPanel();
		pnlDepartment.setLayout(new FlowLayout());
		
			//Add components to Department Panel
			cmbDepartments = new JComboBox<String>();
			cmbDepartments.addItem("");
			for (Department d : Department.values()) {
				cmbDepartments.addItem(d.toString());
			}
			pnlDepartment.add(lblDepartment);
			pnlDepartment.add(cmbDepartments);
			
		// ******* Middle - Section Panel *********
		pnlSectionList = new JPanel();
		pnlSectionList.setLayout(new GridLayout(1,5));
		pnlSectionList.setBackground(Color.WHITE);
		

		// ******* Bottom - Feedback Panel *******
		pnlFeedback = new JPanel();
		pnlFeedback.setLayout(new FlowLayout());
		
			//Add components to Feedback Panel
			pnlFeedback.add(lblFeedback);
		
		//Add Panels to the frame
		this.add(pnlDepartment, BorderLayout.NORTH);
		this.add(pnlSectionList, BorderLayout.CENTER);
		this.add(pnlFeedback, BorderLayout.SOUTH);
	}

	//Methods to set up GUI
	//Set up Frame
	public void setupFrame(){
		
		setMinimumSize(new Dimension(GUI_WIDTH, 120));
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Add the listeners to the components
	public void addListeners(){
		cmbDepartments.addActionListener(new ComboBoxListener());
		//btnCRN.addActionListener(crnListener);
	}
	
	//Inner classes for listeners
		//Inner class for Combo Box
	private class ComboBoxListener implements ActionListener {
		private Department selection;
		private int occurences; 
		@Override
		public void actionPerformed(ActionEvent e) {
			SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					for (Department d : Department.values()) {
						if (cmbDepartments.getSelectedItem().equals(d.toString())) {
							selection = d;
							getOccurences();
							populateList(selection);
							break;
						} else if (cmbDepartments.getSelectedItem().equals("")) {
							pnlSectionList.removeAll();
							pnlSectionList.revalidate();
							pnlSectionList.repaint();
							resetSize();
							doStuff();
							break;
						}
					}
					return null;
				}
				@Override
				public void done() {
				}
			};
			worker.execute();
		}
		private void populateList(Department department) {
			pnlSectionList.removeAll();
			GridLayout gridLayout = new GridLayout((occurences + 1),5);
			pnlSectionList.setSize(GUI_WIDTH, gridLayout.getRows()*30);
			
			//Determine extra space needed
			int extraSpace = 0;
			if(gridLayout.getRows() == 1){
				extraSpace = 50;
			}else if(gridLayout.getRows() > 5){
				extraSpace = 120;
			}else{
				extraSpace = 80;
			}
			
			resize2(1200, ((pnlDepartment.getHeight() + pnlSectionList.getHeight() + pnlFeedback.getHeight()) + extraSpace));
			pnlSectionList.setLayout(gridLayout);
			pnlSectionList.add(lblCRN = new JLabel("Click CRN to add or drop course"));
			pnlSectionList.add(lblCourseNum = new JLabel("Course Number"));
			pnlSectionList.add(lblTitle = new JLabel("Title"));
			pnlSectionList.add(lblInstructor = new JLabel("Instructor"));
			pnlSectionList.add(lblSchedule = new JLabel("Schedule"));
			
			//Border
			Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.DARK_GRAY);
			
			//Set the text color for headers
			lblCRN.setForeground(Color.BLUE);
			lblCRN.setBackground(Color.WHITE);
			lblCRN.setOpaque(true);
			lblCRN.setBorder(bottomBorder);
			lblCourseNum.setForeground(Color.BLUE);
			lblCourseNum.setBackground(Color.WHITE);
			lblCourseNum.setOpaque(true);
			lblCourseNum.setBorder(bottomBorder);
			lblTitle.setForeground(Color.BLUE);
			lblTitle.setBackground(Color.WHITE);
			lblTitle.setOpaque(true);
			lblTitle.setBorder(bottomBorder);
			lblInstructor.setForeground(Color.BLUE);
			lblInstructor.setBackground(Color.WHITE);
			lblInstructor.setOpaque(true);
			lblInstructor.setBorder(bottomBorder);
			lblSchedule.setForeground(Color.BLUE);
			lblSchedule.setBackground(Color.WHITE);
			lblSchedule.setOpaque(true);
			lblSchedule.setBorder(bottomBorder);
			
			
			//For alternating gold bg
			boolean goldBg = false;
			JLabel lblCourseGrid, lblTitleGrid, lblInstructorGrid, lblSchedGrid;
			
			//Loop to populate the sections
			for (Section s : term.getSections()) {
				if (s.getCourse().getDepartment().toString().equals(department.toString())) {
					
					JPanel pnlButtonPanel = new JPanel();
					pnlButtonPanel.add(btnCRN = new JButton(s.getCRN().toString()));
					btnCRN.addActionListener(crnListener);

					pnlButtonPanel.setBorder(bottomBorder);
					pnlSectionList.add(pnlButtonPanel);
					
					pnlSectionList.add(lblCourseGrid = new JLabel(s.getCourse().getCourseNumber()));
					lblCourseGrid.setBorder(bottomBorder);
					pnlSectionList.add(lblTitleGrid = new JLabel(s.getCourse().getTitle()));
					lblTitleGrid.setBorder(bottomBorder);
					pnlSectionList.add(lblInstructorGrid = new JLabel(s.getInstructor().getLastName()));
					lblInstructorGrid.setBorder(bottomBorder);
					pnlSectionList.add(lblSchedGrid = new JLabel(s.getSchedule()));
					lblSchedGrid.setBorder(bottomBorder);
					
					//for color
					if(goldBg){
						pnlButtonPanel.setBackground(new Color(219, 219, 114));
						
						lblCourseGrid.setBackground(new Color(219, 219, 114));
						lblCourseGrid.setOpaque(true);
						
						lblTitleGrid.setBackground(new Color(219, 219, 114));
						lblTitleGrid.setOpaque(true);
						
						lblInstructorGrid.setBackground(new Color(219, 219, 114));
						lblInstructorGrid.setOpaque(true);
						
						lblSchedGrid.setBackground(new Color(219, 219, 114));
						lblSchedGrid.setOpaque(true);
					}else{
						pnlButtonPanel.setBackground(Color.WHITE);
					}
					
					//Change goldBg
					goldBg = !goldBg;
					
				}
			}

			pnlSectionList.revalidate();
			pnlSectionList.repaint();
		}
		private void getOccurences() {
			occurences = 0;
			for (Section s : term.getSections()) {
				if (s.getCourse().getDepartment().toString().equals(selection.toString())) {
					occurences++;
				}
			}
			lblFeedback.setText(occurences + " sections of " + selection + " found.");
		}
		private void doStuff() {
			lblFeedback.setText("");
			for (Section studentSec : student.getSections().values()) {
				lblFeedback.setText(lblFeedback.getText() + studentSec.getCRN() + " " +
						studentSec.getCourse().getTitle() + ", ");
			}
			lblFeedback.revalidate();
		}
	}

// Inner class for Action Listener for CRN Buttons
private ActionListener crnListener = new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		//Save CRN that is clicked
		String btnText = e.getSource().toString();
		btnText = btnText.substring(btnText.indexOf("text="), btnText.indexOf(",defaultCapable="));
		btnText = btnText.substring(btnText.lastIndexOf('=') + 1);
		
		int crn = Integer.parseInt(btnText);
		boolean dropped = false;
		for (Entry<Integer, Section> entry : student.getSections().entrySet()) {
			if (entry.getValue().getCRN() == crn) {
				student.drop(entry.getValue());
				lblFeedback.setText("");
				for (Section studentSec : student.getSections().values()) {
					lblFeedback.setText(lblFeedback.getText() + studentSec.getCRN() + " " +
							studentSec.getCourse().getTitle() + ", ");
				}
				dropped = true;
				break;
			}
		}
		if (!dropped) {
			for (Section termSec : term.getSections()) {
				if (crn == termSec.getCRN()) {
					lblFeedback.setText("");
					for (Section studentSec : student.getSections().values()) {
						lblFeedback.setText(lblFeedback.getText() + studentSec.getCRN() + " " +
								studentSec.getCourse().getTitle() + ", ");
					}
					if (tryAdd(termSec)) {
						lblFeedback.setText(lblFeedback.getText() + crn + " " + 
								termSec.getCourse().getTitle());
					}
					lblFeedback.revalidate();
					break;
				}
			}
		}
	}
	
	private boolean tryAdd(Section add) {
		//if add is an online section there is no chance of schedule conflict, so add it
		if (add.getClass().getSimpleName().equals("OnlineSection")) {
			if (add.validateChoice()) {
				student.add(add);
				return true;
			}
		} else {			//else it is a traditional or hybrid section and therefore needs to be checked for
							// schedule conflict
			if (add.validateChoice()) {
				//loop through all the classes student is currently registered for
				for (Section s : student.getSections().values()) {
					//if it is not an online course (no possibility of time conflict) then continue
					if (!s.getClass().getSimpleName().equals("OnlineSection")) {
						try {
							//loop through all the time slots of the 2 sections being checked (the one
							//to be added and the current section in student being looked at)
							for (TimeSlot ts : s.getTimeSlot()) {
								for (TimeSlot ts2 : add.getTimeSlot()) {
									if (ts.getWeekday().equals(ts2.getWeekday())) {
										if (ts.getStartTime().equals(ts2.getStartTime())) {
											//conflict found, print error and leave the method
											JOptionPane.showMessageDialog(null, "There was a scheduling conflict: "
													+ add.getCRN() + " was not added.", "Schedule conflict", 
													JOptionPane.ERROR_MESSAGE);
											return false;
										}
									}
								}
							}
						} catch (NoTimeSlotFoundException e) {
							e.printStackTrace();
						}
					}
				}
				//else no error was found, add the course
				student.add(add);
				return true;
			}
		}
		return false;
	}
};
	
private void resize2(int width, int height) {
	this.setSize(width, height);
}

private void resetSize() {
	this.setSize(GUI_WIDTH, 120);
	this.pack();
}

}
