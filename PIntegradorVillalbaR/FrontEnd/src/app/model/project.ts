export class Project {
  id?: number;
  proName?: string;
  proDescription?: String;
  proImg?: string;
  opUrl?: string;
  altImg?: string;
  repository?: string;

  constructor(
    proName: string,
    proDescription: String,
    proImg: string,
    opUrl: string,
    altImg: string,
    repository: string
  ) {
    this.proName = proName;
    this.proDescription = proDescription;
    this.proImg = proImg;
    this.opUrl = opUrl;
    this.altImg = altImg;
    this.repository = repository;
  }
}
