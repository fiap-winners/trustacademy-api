package com.api.trustacademy.gateways;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.ByteBuffer;
import com.amazonaws.util.IOUtils;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.BoundingBox;
import com.amazonaws.services.rekognition.model.CompareFacesMatch;
import com.amazonaws.services.rekognition.model.CompareFacesRequest;
import com.amazonaws.services.rekognition.model.CompareFacesResult;
import com.amazonaws.services.rekognition.model.ComparedFace;

@Service
public class AWSRekognitionGateway {

	public boolean compareFaces(MultipartFile sourceImage, MultipartFile targetImage) {
		Float similarityThreshold = 70F;
		ByteBuffer sourceImageBytes = null;
		ByteBuffer targetImageBytes = null;

		AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();

		// Load source and target images and create input parameters
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

		// Call operation
		CompareFacesResult compareFacesResult = rekognitionClient.compareFaces(request);

		// Display results
		List<CompareFacesMatch> faceDetails = compareFacesResult.getFaceMatches();
		for (CompareFacesMatch match : faceDetails) {
			ComparedFace face = match.getFace();
			BoundingBox position = face.getBoundingBox();
			System.out.println("Face at " + position.getLeft().toString() + " " + position.getTop() + " matches with "
					+ match.getSimilarity().toString() + "% confidence.");

		}
		List<ComparedFace> uncompared = compareFacesResult.getUnmatchedFaces();

		System.out.println("There was " + uncompared.size() + " face(s) that did not match");
		return false;
	}
}
