package Lab11;

// linkedlist
class BlueRayCollection {
    private BlueRayDisk head;

    public BlueRayCollection() {
        head = null;
    }

    public void addDisk(String title, String director, int yearOfRelease, double cost) {
        BlueRayDisk newDisk = new BlueRayDisk(title, director, yearOfRelease, cost);

        if (head == null) {
            head = newDisk;
            return;
        }

        BlueRayDisk current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newDisk;
    }

    public String showAll() {
        if (head == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        BlueRayDisk current = head;

        while (current != null) {
            result.append(current.toString());
            current = current.next;

            if (current != null) {
                result.append("\n");
            }
        }

        return result.toString();
    }
}