public class DessinPlateau
{
        private final String[] tabNomCase = {
                "cp13",
                "cp14",
                "cp15",
                "cm5",
                "cm6",
                "cp16",
                "cp17",
                "cm7",
                "cc1",
                "cc2",
                "cm8",
                "cp18",
                "cp19",
                "cm9",
                "cc3",
                "cc4",
                "cm10",
                "cp20",
                "cp21",
                "cm11",
                "cm12",
                "cp22",
                "cp23",
                "cp24",	
        };
        private int nume = 0;
        private boolean passage = false;

        public DessinPlateau()
        {
            System.out.println();
            for(int i = 0; i < 2; i++)
            {
                if(i == 1)
                {
                    System.out.printf("%-27s", "");
                    System.out.printf("%-6s", "/");
                    barrePlateau(2);
                    System.out.printf("%-27s", "\\");
                    System.out.println();
                    for(int j = 0; j < 2; j++)
                    {
                        if(j == 1)
                        {
                            System.out.printf("%-24s", "");
                            System.out.printf("%-3s", "/");
                            barrePlateau(3);
                            System.out.printf("%-3s", "|");
                            System.out.println("\\");
                            for(int k = 0; k < 2; k++)
                            {
                                if(k == 1)
                                {
                                    System.out.printf("%-21s", "");
                                    barrePlateau(5);
                                    System.out.println("|");
                                }
                                System.out.printf("%-20s", "");
                                System.out.printf("%-4s", retourneNomCase()+"--");
                                traitPlateau();
                                System.out.printf("%-4s", retourneNomCase()+"--");
                                System.out.println(retourneNomCase());
                            }
                            System.out.printf("%-24s", "");
                            System.out.printf("%-3s", "\\");
                            barrePlateau(3);
                            System.out.printf("%-3s", "|");
                            System.out.println("/");
                        }
                        System.out.printf("%-25s", "");
                        traitPlateau();
                        System.out.println(retourneNomCase());
                    }
                    System.out.printf("%-27s", "");
                    System.out.printf("%-6s", "\\");
                    barrePlateau(2);
                    System.out.println("/");
                }
                System.out.printf("%-29s", "");
                System.out.printf("%-7s", retourneNomCase()+"-------");
                System.out.println(retourneNomCase());
            }
        }

        public String retourneNomCase() {
            if(this.passage == false) {
                this.passage = true;
                return this.tabNomCase[this.nume];
            } 
            else
            {
                this.nume++;
                return this.tabNomCase[this.nume];
            }
        }

        public void traitPlateau() {
            for(int i = 0; i < 3; i++) {
                System.out.printf("%-4s", retourneNomCase()+"---");
            }
        }

        public void barrePlateau(int nbr) {
            for(int i = 0; i < nbr; i++) {
                System.out.printf("%-6s", "|");
            }
        }

}
