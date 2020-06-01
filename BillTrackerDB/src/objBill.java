public class objBill {
    public String doc;		// Document name for this legislative body
    public String intro;	// Primary Introducer is the source of who proposed the bill
    public String stat;	// This is the status of the current bill
    public String desc;	// general string description of the bill
    public int ID;			// Unique document ID
    public boolean isEnd;	// boolean value to mark the end of the linked list
    public objBill next;	// Next bill in the list
 
    /** Constructor **/
    public objBill() {//default constructor for initial linked list and end of list.
    	this.doc = "";
    	this.intro = "";
    	this.stat = "";
    	this.desc = "";
    	this.ID = -1;
    	this.isEnd = true;
    	this.next = null;
    }
    public objBill(String doc, String intro, String stat, String desc, int ID, objBill next) {
    	this.doc = doc;
    	this.intro = intro;
    	this.stat = stat;
    	this.desc = desc;
    	this.ID = ID;
    	this.isEnd = false;
    	this.next = next;
    }
}
