/*
 * WEEK 8 - TASK 1
 * Problem: Java Method Overriding
 * Platform: HackerRank
 *
 * Question: Override getNumberOfTeamMembers() in Soccer so that it prints
 * the soccer-specific number of players.
 */

class Sports {
    String getName() {
        return "Generic Sports";
    }

    void getNumberOfTeamMembers() {
        System.out.println("Each team has n players in " + getName());
    }
}

class Soccer extends Sports {
    @Override
    String getName() {
        return "Soccer Class";
    }

    @Override
    void getNumberOfTeamMembers() {
        System.out.println("Each team has 11 players in " + getName());
    }
}

class JavaMethodOverriding {
    public static void main(String[] args) {
        Sports sports = new Sports();
        Soccer soccer = new Soccer();
        System.out.println(sports.getName());
        sports.getNumberOfTeamMembers();
        System.out.println(soccer.getName());
        soccer.getNumberOfTeamMembers();
    }
}
