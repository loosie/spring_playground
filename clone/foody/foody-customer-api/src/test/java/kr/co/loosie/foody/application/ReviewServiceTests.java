package kr.co.loosie.foody.application;

import kr.co.loosie.foody.application.ReviewService;
import kr.co.loosie.foody.domain.Review;
import kr.co.loosie.foody.domain.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ReviewServiceTests {

    private ReviewService reviewService ;

    @Mock
    private ReviewRepository reviewRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        reviewService = new ReviewService(reviewRepository);
    }

    @Test
    public void addReview(){


        reviewService.addReview(1004L,"JOKER",3,"good");

        verify(reviewRepository).save(any());
    }

}