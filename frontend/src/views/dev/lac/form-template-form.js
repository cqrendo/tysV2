import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '../../../components/form-buttons-bar.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '../../generic/crud-view.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '../../../components/buttons-bar.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import '@vaadin/vaadin-tabs/src/vaadin-tab.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-dialog/src/vaadin-dialog.js';
import '../../generic/layout/dynamic-grid-for-pick.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';

import '@vaadin/vaadin-accordion/src/vaadin-accordion.js';
import '@vaadin/vaadin-accordion/src/vaadin-accordion-panel.js';

class FormTemplateForm extends PolymerElement {
  static get template() {
    return html`
<style>
      :host {
/*         height: 100%; */
        width: 100%;
/*         margin: 5px; */
        
      }

       vaadin-form-layout { 
       
        overflow: auto; 
       } 
      :host(.custom-style) [part="input-field"] {
        border: 10px solid #ccc;
        background-color: #bbb;
      }
       :host([focused].custom-style) [part="input-field"] {
        border-color: #aaa;
      }
	    
       vaadin-form-item { 
       
    	flex: auto ;
	    overflow: auto; 
 	    --vaadin-form-item-label-width: 1em; 
        --vaadin-form-item-label-spacing: 1em;
        --vaadin-form-item-row-spacing: 1.25em; 
 	    }  
    
          
      vaadin-text-field.veryBig{
                width: var(--vaadin-text-field-default-width, 28em);
                margin-left: 5px;
      }
      
      vaadin-text-field.big{
                width: var(--vaadin-text-field-default-width, 20em);
                margin-left: 5px;
      }
      vaadin-text-field.medium{
                width: var(--vaadin-text-field-default-width, 10em);
                margin-left: 5px;
            }
      vaadin-text-field.veryVerySmall{
                width: var(--vaadin-text-field-default-width, 2em);
                margin-left: 5px;
            }
      vaadin-text-field.verySmall{
            width: var(--vaadin-text-field-default-width, 4em);  
/*  				width : 4em;  */
 				margin-left: 5px;
             }  
      vaadin-text-field.small{
                width: var(--vaadin-text-field-default-width, 8em);
                margin-left: 5px;
            }  
      vaadin-date-picker {
      			width: var(--vaadin-text-field-default-width, 10em);
      			margin-left: 5px;
      }  
      div.linCampos {
/*       margin-top: 0px; */
      margin-left: 20px;
/*       height: 70px; */
/*       text-align:justify; */
/*       	display: flex;  */
      
/*        justify-content: left;  */
      } 
      div.lastColumn {
      float:right;
      margin-right:24px;
      }     
/*       vaadin-form-item{ */
/*       	background-color: rgba(0, 0, 0, 0.05); */
/*             }                 */
/* /*       vaadin-text-field { */ */
/* /*   	border: 10px solid gray; */ */
/*   	height:"100px""; */
  	
/* 		} */
	clean{
		padding-right:  0.75rem; margin-right: 0px;"
	}
	/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}

    </style>
<h3 id="title" style="height:0px"></h3>
<div>
 <vaadin-button id="preview" slot="left" theme="raised secundary">
  <iron-icon icon="lumo:eye" < iron-icon></iron-icon>
 </vaadin-button>
 <vaadin-button id="update" slot="left" theme="raised secundary">
  <iron-icon icon="lumo:reload" < iron-icon></iron-icon>
 </vaadin-button>
 <vaadin-form-layout id="form"></vaadin-form-layout>
 <div class="linCampos">
  <vaadin-text-field id="col0" label="Nombre " class="big"></vaadin-text-field>
  <vaadin-text-field id="col1" label="Recurso" class="big"></vaadin-text-field> 
 </div>
 <vaadin-accordion opened=null>
  <vaadin-accordion-panel theme="small">
   <div slot="summary">
     Otros datos 
   </div>
   <div class="linCampos">
    <vaadin-text-field id="col13" label="Título Listado " class="veryBig"></vaadin-text-field>
    <vaadin-text-field id="col12" label="Título Búsqueda" class="veryBig"></vaadin-text-field>
    </div>
    <div class="linCampos">
    <vaadin-text-field id="col11" label="Título Formulario" class="veryBig"></vaadin-text-field>
     </div>
    <div class="linCampos">
    <vaadin-text-field id="col2" label="Etiqueta:(L)ado (T)ope "></vaadin-text-field>
    <vaadin-text-field id="col10" label="CSS" class="veryBig"></vaadin-text-field>
  	 </div>
   </div>
  </vaadin-accordion-panel>
  <vaadin-accordion-panel theme="small">
   <div slot="summary">
     Campos listado 
   </div>
   <vaadin-text-area id="col4" label="Texto a procesar" style="height:380px;width:864px "></vaadin-text-area>
  </vaadin-accordion-panel>
  <vaadin-accordion-panel theme="small">
   <div slot="summary">
     Campos Búsqueda 
   </div>
   <vaadin-text-area id="col5" label="Texto a procesar" style="height:380px;width:964px "></vaadin-text-area>
  </vaadin-accordion-panel>
  <vaadin-accordion-panel theme="small">
   <div slot="summary">
     Campos Formulario 
   </div>
   <vaadin-text-area id="col6" label="Texto a procesar" style="height:380px;width:964px "></vaadin-text-area>
  </vaadin-accordion-panel>
 </vaadin-accordion>
 <!--  <vaadin-custom-field id="col25" label="Total" required error-message="Please fill in all fields"> -->
 <!--   <input type="decimal" id="input"> -->
 <!--   <select><option>Euro</option><option>Dollars</option><option>Pounds</option></select> -->
 <!--  </vaadin-custom-field> -->
</div>
<vaadin-dialog id="dialogForPick"></vaadin-dialog>
`;
  }

  static get is() {
    return 'form-template-form';
  }
  ready() {
    super.ready();
    this.$.form.addEventListener('change', e => {
      this.$.buttons.$.save.disabled = false;
    });
  }
}
window.customElements.define(FormTemplateForm.is, FormTemplateForm);

