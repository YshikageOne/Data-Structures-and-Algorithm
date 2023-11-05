package week13.TicketBookingSystem;

import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
/*
 * Simple Ticket Booking System
 * @author Clyde Allen T. Yu
 */
public class TicketBookingSystem extends JFrame implements ActionListener{
	
	private JTextArea txtArea;
	private PriorityQueue<TicketRequest> ticketQueue;
	private Random random;
	private int totalRequests = 0;
	private long totalWaitingTime = 0;
	private Set<String> customerNames = new HashSet<>();
	
	public TicketBookingSystem() {
		//Main window attributes
		setTitle("Ticket Booking System Made by Clyde Yu :)");
		setSize(550,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//Create a panel to hold the components
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		//Create the output text area
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtArea);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		//Create the menu bar and menu items
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_M);
		
		JMenuItem mnuItemAdd = new JMenuItem("Add Ticket");
		mnuItemAdd.setAccelerator(KeyStroke.getKeyStroke('A', CTRL_DOWN_MASK));
		
		JMenuItem mnuProcess = new JMenuItem("Process Ticket");
		mnuProcess.setAccelerator(KeyStroke.getKeyStroke('P', CTRL_DOWN_MASK));
		
		JMenuItem mnuView = new JMenuItem("View Next Ticket");
		mnuView.setAccelerator(KeyStroke.getKeyStroke('V', CTRL_DOWN_MASK));
		
		JMenuItem mnuPending = new JMenuItem("Check Pending");
		mnuPending.setAccelerator(KeyStroke.getKeyStroke('C', CTRL_DOWN_MASK));
		
		JMenuItem mnuDisplay = new JMenuItem("Display All");
		mnuDisplay.setAccelerator(KeyStroke.getKeyStroke('D', CTRL_DOWN_MASK));
		
		JMenuItem mnuShowStats = new JMenuItem("Show Statistics");
	    mnuShowStats.setAccelerator(KeyStroke.getKeyStroke('S', CTRL_DOWN_MASK));
	    
		mnuItemAdd.addActionListener(this);
		mnuProcess.addActionListener(this);
		mnuView.addActionListener(this);
		mnuPending.addActionListener(this);
		mnuDisplay.addActionListener(this);
		mnuShowStats.addActionListener(this);
		
		menu.add(mnuItemAdd);
		menu.add(mnuProcess);
		menu.add(mnuView);
		menu.add(mnuPending);
		menu.add(mnuDisplay);
		menu.add(mnuShowStats);
		
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		//Adding the panel to the frame
		add(panel);
		getContentPane().setBackground(new Color(100,50,0,85));
		setLocationRelativeTo(null);
		setVisible(true);
		
		//Intializing the ticket queue
		ticketQueue = new PriorityQueue<>();
		
		//Initialize the random number generator
	    random = new Random();
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "Add Ticket":
            //Prompt the user for ticket details
			String customerName = JOptionPane.showInputDialog("Enter customer name:");
			//Duplicate Catcher
            if (customerNames.contains(customerName)) {
                JOptionPane.showMessageDialog(null, "Error: Duplicate customer name");
                break;
            }
            customerNames.add(customerName);
            int numTickets = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tickets:"));

            //Create a new ticket request with current timestamp
            long timestamp = System.currentTimeMillis();
            TicketRequest ticketRequest = new TicketRequest(customerName, numTickets, timestamp);

            //Generate a random processing time between 1 and 60 seconds and add them to the total
            int processingTime = random.nextInt(60) + 1;
            ticketRequest.setProcessingTime(processingTime);
            totalWaitingTime += processingTime;
            
            //Add the ticket to the ticket queue
            ticketQueue.offer(ticketRequest);

            //Display the ticket request
            txtArea.append("Ticket request\t: " + customerName + " - " + numTickets + " tickets {Processing time : " + ticketRequest.getProcessingTime() + " seconds.}\n");
            totalRequests++;
            break;

		case "Process Ticket":
		    //Process the earliest ticket request
		    TicketRequest earliestTicket = ticketQueue.peek();

		    if (earliestTicket != null) {
		        //Remove the earliest ticket request from the queue
		        ticketQueue.remove(earliestTicket);
		        
		        totalWaitingTime -= earliestTicket.getProcessingTime();

		        //Display the ticket request in blue text
		        txtArea.setForeground(Color.BLUE);
	            txtArea.append("Ticket On Process: " + earliestTicket.getCustomerName() + " - " + earliestTicket.getNumTickets() + " tickets {Processing time : " + earliestTicket.getProcessingTime() + " seconds.}\n");

		        //Reset the text color to the default color
		        txtArea.setForeground(UIManager.getColor("TextArea.foreground"));
		    } else {
		        txtArea.append("No pending tickets\n");
		    }
		    break;

			
		case "View Next Ticket": 
			//Viewing the earliest ticket request without removing
		    TicketRequest earlyTicket = ticketQueue.peek();

		    if (earlyTicket != null) {
		        
		        //Display the ticket request in blue text
		        txtArea.setForeground(Color.GREEN);
	            txtArea.append("Processing Ticket request: " + earlyTicket.getCustomerName() + " - " + earlyTicket.getNumTickets() + " tickets {Processing time : " + earlyTicket.getProcessingTime() + " seconds.}\n");

		        //Reset the text color to the default color
		        txtArea.setForeground(UIManager.getColor("TextArea.foreground"));
		    } else {
		        txtArea.append("No pending tickets\n");
		    }
			break;
			
		case "Check Pending": 
			//Check if there are any pending ticket requests in the queue
		    boolean hasPendingRequests = !ticketQueue.isEmpty();

		    //Clear the text area
		    txtArea.setText("");

		    //Display the check result
		    txtArea.append("Are there any pending ticket requests? " + hasPendingRequests + "\n");

		    //Display the remaining ticket requests
		    if (hasPendingRequests) {
		        txtArea.append("Pending ticket requests:\n");
		        for (TicketRequest ticket : ticketQueue) {
		            txtArea.append(ticket.getCustomerName() + " - " + ticket.getNumTickets() + " tickets\n");
		        }
		    }
		    break;
			
		case "Display All": 
			//Clear the text area
		    txtArea.setText("");

		    //Display all the ticket requests
		    for (TicketRequest ticket : ticketQueue) {
		        txtArea.append("Ticket request\t: " + ticket.getCustomerName() + " - " + ticket.getNumTickets() + " tickets {Processing time : " + ticket.getProcessingTime() + " seconds.}\n");
		    }
			break;
			
		 case "Show Statistics":
             //Display the statistics
             txtArea.append("Queue size: " + getQueueSize() + "\n");
             txtArea.append("Total requests: " + getTotalRequests() + "\n");
             txtArea.append("Average waiting time: " + getAverageWaitingTime() + " seconds\n");
             break;
	    }
	}
	
	public int getQueueSize() {
	    return ticketQueue.size();
	}
	
	public int getTotalRequests() {
	    return totalRequests;
	}
	
	public double getAverageWaitingTime() {
	    if (ticketQueue.size() == 0) {
	        return 0;
	    } else {
	        return (double) totalWaitingTime / ticketQueue.size();
	    }
	}
	
	public static void main(String[] args) {
		new TicketBookingSystem();
	}
}

/*
 * Container for storing the details of a ticket request
 * Encapsulates the data related to a ticket request into a single object
 */

class TicketRequest implements Comparable<TicketRequest> {
    private String customerName;
    private int numTickets;
    private long timestamp;
    private long processingTime;

    public TicketRequest(String customerName, int numTickets, long timestamp) {
        this.customerName = customerName;
        this.numTickets = numTickets;
        this.timestamp = timestamp;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public long getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(long processingTime) {
        this.processingTime = processingTime;
    }

    public int compareTo(TicketRequest other) {
        //Compare ticket requests based on processing time
        //If the processing times are equal, compare based on timestamp
        int result = Long.compare(this.processingTime, other.processingTime);
        if (result == 0) {
            result = Long.compare(this.timestamp, other.timestamp);
        }
        return result;
    }
}
