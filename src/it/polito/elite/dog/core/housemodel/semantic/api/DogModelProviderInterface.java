/*                               
    _/_/_/                         
   _/    _/    _/_/      _/_/_/  
  _/    _/  _/    _/  _/    _/  
 _/    _/  _/    _/  _/    _/ 
_/_/_/      _/_/      _/_/_/    
                         _/                                     
                    _/_/                                
														
WEBSITE: http://elite.polito.it/dog-tools-80

DogModelProviderInterface

Copyright (c) [2011] 
[Dario Bonino (dario.bonino@polito.it), Politecnico di Torino] 
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed 
on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions and limitations under the License. 

 */
package it.polito.elite.dog.core.housemodel.semantic.api;

import java.util.Set;

import it.polito.elite.dog.core.housemodel.semantic.util.OntologyDescriptorSet;

import com.hp.hpl.jena.ontology.OntModel;


/**
 * An interface defining the minimum set of functionalities required by a core
 * semantic house model (or by other equivalent bundles) to support the runtime
 * addition/removal of additional modeling primitives (i.e., ontology classes
 * and instances). In principle the added models shall directly or indirectly
 * import the core model, however the interface definition leaves space for
 * implementations able to handle disjoint models.
 * 
 * @author bonino
 * 
 */
public interface DogModelProviderInterface
{
	/**
	 * Provides a pointer (class reference) to the Jena OntModel kept by the
	 * class implementing this interface, it is used to support modularity of
	 * modeling concerns in the Semantic House Model bundles (core+extensions)
	 * 
	 */
	public OntModel getModel();
	
	/**
	 * Requires the class implementing this interface to update the inner model
	 * by loading and merging the model whose location is specified in the
	 * message parameter
	 * 
	 * @param 
	 */
	public void loadAndMerge(OntologyDescriptorSet setToLoad);
	
	/**
	 * Requires the class implementing this interface to remove from the inner
	 * model the model whose namespace is specified in the message paremeter
	 * 
	 * @param 
	 */
	public void remove(Set<String> modelsToRemove);
}