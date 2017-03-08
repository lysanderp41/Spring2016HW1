/**
 *Lysander Pena
 * Homework 1
 * CSE214 R14
 * Tayo Amuneke, Yiwen Wang
 * Grading TA
 */
public class Student {
    final int MAX_WRITEUPS = 3;
    private String name;
    private int idNumber;
    private int numWriteups;

    /**
     *
     * @return
     *  Returns name of student
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *  Sets student's name to the parameter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *  Returns student's ID number as an int
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     *
     * @param idNumber
     *  Sets student's ID number to the parameter
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     *
     * @return
     *  Returns the number of times the student has been written up
     */
    public int getNumWriteups() {
        return numWriteups;
    }

    /**
     *
     * @param numWriteups
     *  Sets the number of writeups the student has to the parameter
     *
     */
    public void setNumWriteups(int numWriteups) {
        this.numWriteups = numWriteups;
    }

    /**
     *
     * @return
     *  Returns a clone of the student
     * @throws CloneNotSupportedException
     *  Exception is thrown if clone is not supported by the student
     */
    public Student clone() throws CloneNotSupportedException{
        Student cloned = new Student();
        cloned.setIdNumber(idNumber);
        cloned.setName(name);
        cloned.setNumWriteups(numWriteups);
        return cloned;
    }
}
