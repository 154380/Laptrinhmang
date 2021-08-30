package quanlysinhvien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainClass {
    static List<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        studentList = readFile();
        int option = 0;
        while (option!=6)
        {
            showOptionMenu();
            option = scanner.nextInt();
            switch (option)
            {
                case 1:
                   getAllStudent();
                    break;
                case 2:
                   addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    break;
                default:
            }
        }


        System.out.println("\n\n\n--------Kết thúc--------");
    }

    private static List<Student> readFile() {
        List<Student> studentList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File("SV.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentList = (List<Student>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    private static void writeFile(List<Student> studentList) {
            try {
                FileOutputStream fos = new FileOutputStream(new File("SV.txt"));
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(studentList);
                oos.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private static void searchStudent() {
            boolean check = false;
            System.out.println("Nhập tên liên hệ (hoặc MSV) cần tìm: ");
            String search =  scanner.next();
            for (Student s : studentList)
                if (s.getHoTen().contains(search) || s.getMaSV().contains(search))
                {
                    check = true;
                    System.out.println("Tìm thấy");
                    System.out.println(s.toString());
                }
            if (!check)
                System.out.println("Không tìm thấy");
    }

    private static void updateStudent() {
        String maSV, hoTen, nhom;
        int vtri = -9;
        while (vtri==-9)
        {
            System.out.println("Nhập Mã Sinh Viên cần Sửa: ");
            maSV =  scanner.next();
            for (int i=0 ; i< studentList.size(); i++)
            {
                if (studentList.get(i).getMaSV().equalsIgnoreCase(maSV))
                {
                    vtri = i;
                    break;
                }
            }
            if (vtri==-9)
                System.out.println("Mã Sinh Viên không tồn tại, vui lòng kiểm tra lại");
        }
        System.out.println("Nhập thông tin cần chỉnh sửa");
        System.out.println("Mã Sinh Viên: ");
        maSV = scanner.next();
        System.out.println("Họ Tên: ");
        hoTen = scanner.next();
        System.out.println("Nhóm: ");
        nhom = scanner.next();
        Student student = new Student(maSV , hoTen , Integer.parseInt(nhom));
        studentList.set(vtri , student);
        writeFile(studentList);
        System.out.println("Chỉnh sửa thành công");
    }

    private static void deleteStudent() {
        boolean check = false;
        int vtri = 0;
        while (!check)
        {
            System.out.println("Nhập Mã Sinh Viên cần xóa: ");
            String maSV =  scanner.next();

            for (int i=0; i<studentList.size(); i++)
            {
                if (studentList.get(i).getMaSV().equalsIgnoreCase(maSV))
                {
                    check = true;
                    vtri = i;
                    break;
                }

            }
            if (!check)
                System.out.println("Mã Sinh Viên không tồn tại, vui lòng kiểm tra lại");
        }
        System.out.println("Xác nhận xóa sinh viên "+studentList.get(vtri).getHoTen()+" ? (Nhập Y nếu có)");
        String confirm = scanner.next();
        if (confirm.equalsIgnoreCase("Y"))
        {
            studentList.remove(vtri);
            System.out.println("Xóa thành công");
        }else
        {
            System.out.println("Chưa xóa sinh viên");
        }
        writeFile(studentList);
    }

    private static void addStudent() {
        System.out.println("Nhập thông tin sinh viên mới");
        String maSV, hoTen, nhom;
        System.out.println("Mã Sinh Viên: ");
        maSV = scanner.next();
        System.out.println("Họ Tên: ");
        hoTen = scanner.next();
        System.out.println("Nhóm: ");
        nhom = scanner.next();
        studentList.add(new Student(maSV , hoTen , Integer.parseInt(nhom)));
        writeFile(studentList);
        System.out.println("Thêm mới thành công");
    }

    private static void getAllStudent() {
        System.out.println("Danh sách sinh viên: ");
        studentList = readFile();
        studentList.forEach(item->
                {
                    System.out.println(item.toString());
                }
                );
    }

    private static void showOptionMenu() {
        System.out.println("\n\n--CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN--");
        System.out.println("Chọn chức năng...");
        System.out.println("1. Xem danh sách sinh viên");
        System.out.println("2. Thêm mới sinh viên");
        System.out.println("3. Thay đổi thông tin sinh viên");
        System.out.println("4. Xóa sinh viên");
        System.out.println("5. Tìm kiếm sinh viên");
        System.out.println("6. Thoát");
        System.out.println("Chọn chức năng: ");
    }
}
