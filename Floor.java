/**
 *Lysander Pena
 * Homework 1
 * CSE214 R14
 * Tayo Amuneke, Yiwen Wang
 * Grading TA
 */
public class Floor{
    private Student[] students;
    final static int CAPACITY = 3;
    private int studentCount = 0;

    /**
     *
     */
    public Floor() {
        students = new Student[CAPACITY];
    }

    /**
     *
     * @param student
     *  Student being added to floor
     * @param position
     *  Desired position to add student in
     * @throws FullFloorException
     *  If floor does not contain any empty space, exception is thrown
     * @throws IllegalArgumentException
     *  Exception is thrown if user attempts to add a student in a position less than zero, greater than CAPACITY, or
     *  at a position that leaves a hole in the floor
     */
    public void addStudent(Student student, int position) throws FullFloorException, IllegalArgumentException {
        //check for cases that would throw exceptions
        if(students[CAPACITY-1] != null)
            throw new FullFloorException();
        if((position<0 || position>=CAPACITY) || (position > 0 && students[position-1] == null)) {
            throw new IllegalArgumentException();
        }
        if(students[position]!=null) {
            shiftRight(position);
        }
        students[position] = student;
        studentCount++;
    }

    /**
     *
     * @param position
     *  Desired position to remove student from
     * @return tempStudent
     *  Returns the student that was removed from the floor
     * @throws EmptyFloorException
     *  If floor does not contain any students exception is thrown
     * @throws IllegalArgumentException
     *  Exception is thrown if position is less than 0, greater than or equal to capacity, or does not contain a student
     */
    public Student removeStudent(int position) throws EmptyFloorException, IllegalArgumentException {
        if(students[0] == null)
            throw new EmptyFloorException();
        else if((position<0 || position>=CAPACITY) || (position > 0 && students[position-1] == null))
            throw new IllegalArgumentException();
        Student tempStudent = students[position];
        students[position] = null;
        shiftLeft(position);
        System.out.println(tempStudent.getName() + " has successfully been removed!");
        return tempStudent;
    }

    /**
     *
     * @param position
     *  Position of desired student
     * @return students[position]
     *  Returns the student at the desired position
     * @throws IllegalArgumentException
     *  Exception is thrown if position is less than 0, greater than or equal to capacity, or does not contain a student
     */
    public Student getStudent(int position) throws IllegalArgumentException {
        if((position<0 || position>=CAPACITY) || (position > 0 && students[position-1] == null))
            throw new IllegalArgumentException();
        return students[position];
    }

    /**
     *
     * @param position
     *  Position at which the user wants to set a student to
     * @param student
     *  Student being set to position
     * @throws IllegalArgumentException
     *  Exception is thrown if the student being set is null, is in an invalid position, or if there is a hole in the floor
     */
    public void setStudent(int position, Student student) throws IllegalArgumentException {
        if(student == null)
            throw new IllegalArgumentException();
        if(position<0 || position>=CAPACITY )
            throw new IllegalArgumentException();
        if(position-1>=0) {
            if(students[position - 1] == null)
                throw new IllegalArgumentException();
        }
        students[position] = student;
    }

    /**
     *
     * @return studentCount
     *  Returns the amount of students on the floor
     */
    public int count() {
        return studentCount;
    }

    /**
     *
     * @return cloned
     *  Returns a copy of the floor object
     * @throws CloneNotSupportedException
     *  If floor does not support clone, exception is thrown
     */
    public Floor clone() throws CloneNotSupportedException{
        Floor cloned = new Floor();
        for(int i=0;i<students.length;i++) {
            if(students[i] == null)
                cloned.students[i] = null;
            else
                cloned.getStudents()[i] = students[i].clone();
        }
        return cloned;
    }

    /**
     *Prints all non-null students(Name, ID, writeups)
     */
    public void printFloor() {
        System.out.println("Name\t" + "ID number\t" + "Writeups");
        System.out.println("-------------------------------------------------");
        for(Student s:students) {
            if(s != null)
                System.out.println(s.getName() + "\t" + s.getIdNumber() + "\t" + s.getNumWriteups());
        }
        System.out.println("-------------------------------------------------");
    }

    /**
     *
     * @param name
     *  Name that is used to search for a student
     * @return
     *  Boolean value indicating whether or not a student was found and written up
     * @throws EmptyFloorException
     *  Exception is thrown if floor does not contain any students
     */
    public boolean writeup(String name) throws EmptyFloorException{
        int count = 0;
        while(students[count] != null) {
            if(students[count].getName().equals(name)) {
                students[count].setNumWriteups(students[count].getNumWriteups()+1);
                if(students[count].getNumWriteups()==3) {
                    System.out.println(students[count].getName() + " has exceeded 3 writeups and was removed from the floor.");
                    this.removeStudent(count);
                }
                return true;
            }
            count++;
        }
        return false;
    }

    /**
     *
     * @param position
     *  Position from which the floor will be shifted left
     */
    public void shiftLeft(int position) {
        System.arraycopy(students,position+1,students,position,students.length-position-1);
        students[CAPACITY-1] = null;
    }

    /**
     *
     * @param position
     *  Position from which all students will be shifted to the right
     */
    public void shiftRight(int position) {
        System.arraycopy(students,position,students,position+1,students.length-position-1);
    }

    /**
     *
     * @return students
     *  Returns the array of students on the floor
     */
    public Student[] getStudents() {
        return students;
    }
}
