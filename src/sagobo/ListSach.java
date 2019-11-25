
package sagobo;
import java.util.Scanner;
public class ListSach {
    public Book[] listsach;
    public int sosach;
    Scanner inp= new Scanner(System.in);
    public void menu() {
        do {
            System.out.println();
            System.out.println("             QUẢN LÝ SÁCH");
            System.out.println("-------------------***------------------");
            System.out.println("|    1. Thêm sách.                      |");
            System.out.println("|    2. Sửa thông tin.                  |");
            System.out.println("|    3. Xóa sách.                       |");
            System.out.println("|    4. Xem danh sách.                  |");
            System.out.println("|    5.. Tìm kiếm.                      |");
            //System.out.println("|    6.. Sắp xếp theo tên.               |");
            System.out.println("|    9. Quay lại menu chính.            |");
            System.out.println("|    0. Thoát chương trình.             |");
            System.out.println("----------------------------------------");
            System.out.print("  Mời chọn chức năng: ");
            int n = Integer.parseInt(inp.nextLine());
            switch (n) {
                case 1:
                    themSach();
                    break;
                case 2:
                    xoaSach();
                    break;
                case 3:
                    xuatDanhSach();
                    break;
                case 4:
                    timSach();
                    break;
                case 5:
                    menu();
                    break;
                case 9:
                    Menu mainmenu = new Menu();
                    mainmenu.menu();
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("\n---------------------KẾT THÚC MENU QUẢN LÝ SÁCH------------------\n");
        } while (true);
    }


    public void nhapSach(){
        System.out.println("nhap so luong sach");
        sosach= Integer.parseInt(inp.nextLine());
        int i;
        listsach = new Book[sosach];
        for(i=0;i<sosach;i++){
            System.out.println("nhap loai sach :");
                    int selection= Integer.parseInt(inp.nextLine());
            switch(selection){
                case 1 :
                    listsach[i]= new SachVanHoc();
                    listsach[i].nhap();
                    break;
                case 2 :
                    listsach[i]= new SachThieuNhi();
                    listsach[i].nhap();
                    break;
            }
        }
    }
    public void xoaSach(){
        int c,i;
        String xoaMaSach;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma sach muon xoa: ");
        xoaMaSach = sc.nextLine();
        for(c=i=0;i<sosach;i++){
            if(listsach[i].getMaSach() == null ? xoaMaSach != null : !listsach[i].getMaSach().equals(xoaMaSach)) {
                listsach[c]=listsach[i];
                c++;}
        }
        sosach=c;
    }
    public void timSach(){
        String timMaSach;
        int error = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma sach muon tim: ");
        timMaSach = sc.nextLine();
        for(int i=0;i<sosach;i++){
            if(listsach[i].getMaSach().equals(timMaSach)){
                listsach[i].xuatSach();
                error = 0;
            }
        }
        if(error == 1) System.out.println("Khong ton tai ma sach !");
    }
    public void themSach(){
        Book[] temp;
        int j=0;
        temp = new Book[sosach+1];
        System.out.println("nhap loai sach ban muon them : ");
        int selection= Integer.parseInt(inp.nextLine());
        for(int i=0;i<sosach;i++){
            if (listsach[i].getTheLoai.equals("Van Hoc")){
                    temp[i] = new SachVanHoc();
                    temp[i] = listsach[j++];
            }
            else{
                    temp[i] = new SachThieuNhi();
                    temp[i] = listsach[j++];
            }
            }
  
        switch(selection){
            case 1 :
                temp[sosach] = new SachVanHoc();
                temp[sosach].nhap();
                sosach++;
                break;
            case 2 :
                temp[sosach] = new SachThieuNhi();
                temp[sosach].nhap();
                sosach++; 
                break;
        }
        listsach=temp;
}
    public void giaodien(){
        System.out.println("=================================================================================================================================");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s","Masach","Tensach","Theloai","Tacgia","Tinhtrang","Madausach");
        System.out.println("=================================================================================================================================");
    }
    
    public void xuatDanhSach(){
        giaodien();
        for(int i=0;i<sosach;i++){
            listsach[i].xuatSach();
        }
    }
    
    
}