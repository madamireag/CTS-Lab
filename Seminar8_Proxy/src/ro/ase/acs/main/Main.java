package ro.ase.acs.main;

import ro.ase.acs.proxy.Authentication;
import ro.ase.acs.proxy.AuthenticationProxy;
import ro.ase.acs.proxy.SecurityAuthenticationException;
import ro.ase.acs.proxy.WebsiteAuthentication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Authentication auth = new AuthenticationProxy(new WebsiteAuthentication());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username;
        username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        try {
            while (!auth.login(username, password)) {
                System.out.println("Invalid credentials!");
                System.out.print("Username: ");
                username = scanner.nextLine();
                System.out.print("Password: ");
                password = scanner.nextLine();
            }

            if (auth.login(username, password)) {
                System.out.println("Logged in successfully!");
            }
        } catch(SecurityAuthenticationException e) {
            System.out.println(e.getMessage());
        }



    }
}
