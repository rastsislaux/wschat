import {Component, Input} from '@angular/core';
import {AuthInfo, Message} from "../message";
import {RestService} from "../rest.service";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-fulltext-search',
  templateUrl: './fulltext-search.component.html',
  styleUrls: ['./fulltext-search.component.css']
})
export class FulltextSearchComponent {
  @Input() authInfo: AuthInfo = { isUnlogged: true, sender: "nobody" };
  formData: any;
  results!: Message[];
  private restService: RestService;

  constructor(
    restService: RestService,
    formBuilder: FormBuilder
  ) {
    this.restService = restService;
    this.formData = formBuilder.group({
      query: ''
    });
  }

  showSearchResults() {
    this.restService.fulltextSearch(this.formData.get("query")?.value)
      .subscribe((data: Message[]) => { this.results = data; } )
  }

}
