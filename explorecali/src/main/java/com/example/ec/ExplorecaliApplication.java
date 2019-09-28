package com.example.ec;

import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
public class ExplorecaliApplication  {

    public static void main(String[] args) {
		SpringApplication.run(ExplorecaliApplication.class, args);
	}

    /**
     * Initialize all the known tour packages
     */
//	private void createTourAllPackages(){
//        tourPackageService.createTourPackage("BC", "Backpack Cal");
//        tourPackageService.createTourPackage("CC", "California Calm");
//        tourPackageService.createTourPackage("CH", "California Hot springs");
//        tourPackageService.createTourPackage("CY", "Cycle California");
//        tourPackageService.createTourPackage("DS", "From Desert to Sea");
//        tourPackageService.createTourPackage("KC", "Kids California");
//        tourPackageService.createTourPackage("NW", "Nature Watch");
//        tourPackageService.createTourPackage("SC", "Snowboard Cali");
//        tourPackageService.createTourPackage("TC", "Taste of California");
//    }

    /**
     * Create tour entities from an external file
    */
//    private void createTours() throws IOException {
//        TourFromFile.read(filePath).forEach(importedTour ->
//            tourService.createTour(importedTour.getTitle(), importedTour.getDescription(), importedTour.getBlurb(),
//                    importedTour.getPrice(), importedTour.getLength(), importedTour.getBullets(),
//                    importedTour.getKeywords(), importedTour.getPackageType(), importedTour.getDifficulty(),
//                    importedTour.getRegion()));
//    }

    /**
     * Helper class to import ExploreCalifornia.json
     */
    private static class TourFromFile {
        //fields
        private String packageType, title, description, blurb, price, length,
                bullets, keywords, difficulty, region;
        //reader
        static List<TourFromFile> read(String filePath) throws IOException {
            return new ObjectMapper().setVisibility(FIELD, ANY).
                    readValue(new FileInputStream(filePath), new TypeReference<List<TourFromFile>>() {});
        }
        protected TourFromFile(){};

        public String getPackageType() {
            return packageType;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getBlurb() {
            return blurb;
        }

        public Integer getPrice() {
            return Integer.parseInt(price);
        }

        public String getLength() {
            return length;
        }

        public String getBullets() {
            return bullets;
        }

        public String getKeywords() {
            return keywords;
        }

        public Difficulty getDifficulty() {
            return Difficulty.valueOf(difficulty);
        }

        public Region getRegion() {
            return Region.findByLabel(region);
        }
    }
}
