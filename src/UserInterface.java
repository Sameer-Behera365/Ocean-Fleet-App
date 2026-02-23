import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VesselUtil util = new VesselUtil();

        System.out.println("Enter the number of vessels to be added");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter vessel details");

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] p = input.split(":");

            Vessel v = new Vessel(
                    p[0],
                    p[1],
                    Double.parseDouble(p[2]),
                    p[3]
            );

            util.addVesselPerformance(v);
        }

        System.out.println("Enter the Vessel Id to check speed");
        String id = sc.nextLine();

        Vessel found = util.getVesselById(id);

        if (found != null) {
            System.out.println(found.getVesselId() + " | "
                    + found.getVesselName() + " | "
                    + found.getVesselType() + " | "
                    + found.getAverageSpeed() + " knots");
        } else {
            System.out.println("Vessel Id " + id + " not found");
        }

        System.out.println("High performance vessels are");

        List<Vessel> top = util.getHighPerformanceVessels();

        for (Vessel v : top) {
            System.out.println(v.getVesselId() + " | "
                    + v.getVesselName() + " | "
                    + v.getVesselType() + " | "
                    + v.getAverageSpeed() + " knots");
        }

        sc.close();
    }
}