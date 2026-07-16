package Inheritance;

public class VideoStore {

    private Video[] store;
    private int count;

    public VideoStore() {
        store = new Video[100];
        count = 0;
    }

    // Add Video
    public void addVideo(String name) {
        store[count++] = new Video(name);
        System.out.println("Video \"" + name + "\" added successfully.");
    }

    // Checkout Video
    public void doCheckout(String name) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                store[i].doCheckout();
                System.out.println("Video \"" + name + "\" checked out successfully.");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    // Return Video
    public void doReturn(String name) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                store[i].doReturn();
                System.out.println("Video \"" + name + "\" returned successfully.");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    // Receive Rating
    public void receiveRating(String name, int rating) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                store[i].receiveRating(rating);
                System.out.println("Rating \"" + rating + "\" has been mapped to the Video \"" + name + "\".");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    // List Inventory
    public void listInventory() {
        System.out.println("----------------------------------------------");
        System.out.printf("%-20s %-18s %s\n", "Video Name", "Checkout Status", "Rating");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.printf("%-20s %-18s %d\n",
                    store[i].getName(),
                    store[i].getCheckout(),
                    store[i].getRating());
        }

        System.out.println("----------------------------------------------");
    }
}