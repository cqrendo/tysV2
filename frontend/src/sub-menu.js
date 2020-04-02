import '@polymer/polymer/polymer-legacy.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
import { PolymerElement } from '@polymer/polymer/polymer-element.js';
class SubMenu extends PolymerElement {
  static get template() {
    return html`
   <vaadin-horizontal-layout> 
    <vaadin-vertical-layout id="butomGroup1">  
     <!--     Button 1  --> 
     <!--   </vaadin-button> --> 
    </vaadin-vertical-layout> 
    <vaadin-vertical-layout id="butomGroup2"> 
     <!--   <vaadin-button> --> 
     <!--     Button 2  --> 
     <!--   </vaadin-button> --> 
    </vaadin-vertical-layout> 
   </vaadin-horizontal-layout> 
`;
  }

  static get is() {
      return 'sub-menu';
  }
  static get properties() {
      return {
          // Declare your properties here. style="width: 100%; height: 100%;margin:100px;">
      };
  }
}
//       customElements.define(TestView.is, TestView);
customElements.define(SubMenu.is, SubMenu);

