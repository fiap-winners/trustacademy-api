package com.api.trustacademy.gateways;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.ByteBuffer;
import com.amazonaws.util.IOUtils;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.CompareFacesMatch;
import com.amazonaws.services.rekognition.model.CompareFacesRequest;
import com.amazonaws.services.rekognition.model.CompareFacesResult;

@Service
public class AWSRekognitionGateway {

	public boolean compareFaces(MultipartFile sourceImage, MultipartFile targetImage) {
		Float similarityThreshold = 70F;
		ByteBuffer sourceImageBytes = null;
		ByteBuffer targetImageBytes = null;

		ClientConfiguration clientConfig = new ClientConfiguration();
	    clientConfig.setConnectionTimeout(30000);
	    clientConfig.setRequestTimeout(60000);
	    clientConfig.setProtocol(Protocol.HTTPS);
	    
		AWSCredentialsProvider credentialsProvider = new ProfileCredentialsProvider("trustacademy-api-rekognition");
		
		AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder
				.standard()
		        .withClientConfiguration(clientConfig)
		        .withCredentials(credentialsProvider)
		        .withRegion("us-east-1")
		        .build();

		try (InputStream inputStream = sourceImage.getInputStream()) {
			sourceImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
		} catch (Exception e) {
			System.out.println("Failed to load source image " + sourceImage);
			return false;
		}
		
		try (InputStream inputStream = targetImage.getInputStream()) {
			targetImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
		} catch (Exception e) {
			System.out.println("Failed to load target images: " + targetImage);
			return false;
		}

		Image source = new Image().withBytes(sourceImageBytes);
		Image target = new Image().withBytes(targetImageBytes);

		CompareFacesRequest request = new CompareFacesRequest().withSourceImage(source).withTargetImage(target)
				.withSimilarityThreshold(similarityThreshold);

		CompareFacesResult compareFacesResult = rekognitionClient.compareFaces(request);

		List<CompareFacesMatch> faceDetails = compareFacesResult.getFaceMatches();
		
		if (faceDetails.size() > 0) {
			return true;
		}
		
		return false;
	}
}
